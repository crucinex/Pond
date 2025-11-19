package com.pond.pomodoro.data.repository

import com.pond.pomodoro.data.dao.PomodoroSessionDao
import com.pond.pomodoro.data.model.PomodoroSession
import kotlinx.coroutines.flow.Flow
import java.util.Calendar

class PomodoroRepository(private val sessionDao: PomodoroSessionDao) {
    fun getAllSessions(): Flow<List<PomodoroSession>> = sessionDao.getAllSessions()
    
    fun getSessionsByTask(taskId: Long): Flow<List<PomodoroSession>> = sessionDao.getSessionsByTask(taskId)
    
    suspend fun insertSession(session: PomodoroSession): Long = sessionDao.insertSession(session)
    
    suspend fun updateSession(session: PomodoroSession) = sessionDao.updateSession(session)
    
    suspend fun getCompletedPomodorosCount(startTime: Long): Int = 
        sessionDao.getCompletedPomodorosCount(startTime)
    
    suspend fun getTotalFocusTime(startTime: Long): Long? = 
        sessionDao.getTotalFocusTime(startTime)
    
    suspend fun getSessionsNeedingSync(): List<PomodoroSession> = 
        sessionDao.getSessionsNeedingSync()
    
    fun getTodaySessions(): Flow<List<PomodoroSession>> {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startOfDay = calendar.timeInMillis
        
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val endOfDay = calendar.timeInMillis
        
        return sessionDao.getSessionsByDate(startOfDay, endOfDay)
    }
}

