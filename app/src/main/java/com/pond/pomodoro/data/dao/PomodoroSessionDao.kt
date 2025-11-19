package com.pond.pomodoro.data.dao

import androidx.room.*
import com.pond.pomodoro.data.model.PomodoroSession
import kotlinx.coroutines.flow.Flow

@Dao
interface PomodoroSessionDao {
    @Query("SELECT * FROM pomodoro_sessions ORDER BY startTime DESC")
    fun getAllSessions(): Flow<List<PomodoroSession>>
    
    @Query("SELECT * FROM pomodoro_sessions WHERE taskId = :taskId ORDER BY startTime DESC")
    fun getSessionsByTask(taskId: Long): Flow<List<PomodoroSession>>
    
    @Query("SELECT * FROM pomodoro_sessions WHERE startTime >= :startOfDay AND startTime < :endOfDay")
    fun getSessionsByDate(startOfDay: Long, endOfDay: Long): Flow<List<PomodoroSession>>
    
    @Query("SELECT COUNT(*) FROM pomodoro_sessions WHERE type = 'FOCUS' AND isCompleted = 1 AND startTime >= :startTime")
    suspend fun getCompletedPomodorosCount(startTime: Long): Int
    
    @Query("SELECT SUM(duration) FROM pomodoro_sessions WHERE type = 'FOCUS' AND isCompleted = 1 AND startTime >= :startTime")
    suspend fun getTotalFocusTime(startTime: Long): Long?
    
    @Query("SELECT * FROM pomodoro_sessions WHERE needsSync = 1")
    suspend fun getSessionsNeedingSync(): List<PomodoroSession>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: PomodoroSession): Long
    
    @Update
    suspend fun updateSession(session: PomodoroSession)
    
    @Delete
    suspend fun deleteSession(session: PomodoroSession)
}

