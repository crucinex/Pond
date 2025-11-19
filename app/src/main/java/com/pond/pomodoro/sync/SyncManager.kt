package com.pond.pomodoro.sync

import android.content.Context
import androidx.work.*
import com.pond.pomodoro.data.repository.PomodoroRepository
import com.pond.pomodoro.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class SyncManager(
    private val context: Context,
    private val taskRepository: TaskRepository,
    private val pomodoroRepository: PomodoroRepository,
    private val calendarSyncService: CalendarSyncService
) {
    
    fun enableAutoSync(enabled: Boolean) {
        if (enabled) {
            schedulePeriodicSync()
        } else {
            cancelPeriodicSync()
        }
    }
    
    suspend fun syncNow(): SyncResult = withContext(Dispatchers.IO) {
        var tasksSynced = 0
        var sessionsSynced = 0
        var errors = 0
        
        try {
            // Sync tasks
            val tasksToSync = taskRepository.getTasksNeedingSync()
            tasksToSync.forEach { task ->
                try {
                    if (task.calendarEventId != null) {
                        // Update existing event
                        if (calendarSyncService.updateCalendarEvent(task)) {
                            taskRepository.updateTask(task.copy(needsSync = false))
                            tasksSynced++
                        } else {
                            errors++
                        }
                    } else if (task.dueDate != null) {
                        // Create new event
                        val eventId = calendarSyncService.createCalendarEvent(task)
                        if (eventId != null) {
                            taskRepository.updateTask(task.copy(
                                calendarEventId = eventId,
                                needsSync = false
                            ))
                            tasksSynced++
                        } else {
                            errors++
                        }
                    }
                } catch (e: Exception) {
                    errors++
                }
            }
            
            // Sync pomodoro sessions
            val sessionsToSync = pomodoroRepository.getSessionsNeedingSync()
            // In a real implementation, you might sync sessions to a backend
            sessionsToSync.forEach { session ->
                // For now, just mark as synced
                pomodoroRepository.updateSession(session.copy(needsSync = false))
                sessionsSynced++
            }
            
        } catch (e: Exception) {
            errors++
        }
        
        SyncResult(tasksSynced, sessionsSynced, errors)
    }
    
    private fun schedulePeriodicSync() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        
        val syncRequest = PeriodicWorkRequestBuilder<SyncWorker>(
            repeatInterval = 15,
            repeatIntervalTimeUnit = TimeUnit.MINUTES
        )
            .setConstraints(constraints)
            .build()
        
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "pond_sync",
            ExistingPeriodicWorkPolicy.KEEP,
            syncRequest
        )
    }
    
    private fun cancelPeriodicSync() {
        WorkManager.getInstance(context).cancelUniqueWork("pond_sync")
    }
    
    data class SyncResult(
        val tasksSynced: Int,
        val sessionsSynced: Int,
        val errors: Int
    )
}

class SyncWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    
    override suspend fun doWork(): Result {
        // This would need to be injected properly
        // For now, we'll use a placeholder
        return try {
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}

