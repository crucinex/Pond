package com.pond.pomodoro.data.repository

import com.pond.pomodoro.data.dao.TaskDao
import com.pond.pomodoro.data.model.Task
import kotlinx.coroutines.flow.Flow
import java.util.Calendar

class TaskRepository(private val taskDao: TaskDao) {
    fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()
    
    fun getTasksByCategory(category: String): Flow<List<Task>> = taskDao.getTasksByCategory(category)
    
    fun getActiveTasks(): Flow<List<Task>> = taskDao.getActiveTasks()
    
    fun getCompletedTasks(): Flow<List<Task>> = taskDao.getCompletedTasks()
    
    fun getTodayTasks(): Flow<List<Task>> {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startOfDay = calendar.timeInMillis
        
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        val endOfDay = calendar.timeInMillis
        
        return taskDao.getTodayTasks(startOfDay, endOfDay)
    }
    
    suspend fun getTaskById(id: Long): Task? = taskDao.getTaskById(id)
    
    suspend fun insertTask(task: Task): Long = taskDao.insertTask(task)
    
    suspend fun updateTask(task: Task) = taskDao.updateTask(task)
    
    suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)
    
    suspend fun getTasksNeedingSync(): List<Task> = taskDao.getTasksNeedingSync()
}

