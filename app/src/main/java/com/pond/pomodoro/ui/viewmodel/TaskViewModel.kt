package com.pond.pomodoro.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pond.pomodoro.data.model.Task
import com.pond.pomodoro.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {
    
    val tasks = taskRepository.getAllTasks()
    val activeTasks = taskRepository.getActiveTasks()
    val completedTasks = taskRepository.getCompletedTasks()
    val todayTasks = taskRepository.getTodayTasks()
    val inboxTasks = taskRepository.getTasksByCategory("inbox")
    
    private val _selectedCategory = MutableStateFlow("inbox")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()
    
    private val _isTaskDialogOpen = MutableStateFlow(false)
    val isTaskDialogOpen: StateFlow<Boolean> = _isTaskDialogOpen.asStateFlow()
    
    private val _editingTask = MutableStateFlow<Task?>(null)
    val editingTask: StateFlow<Task?> = _editingTask.asStateFlow()
    
    fun selectCategory(category: String) {
        _selectedCategory.value = category
    }
    
    fun openTaskDialog(task: Task? = null) {
        _editingTask.value = task
        _isTaskDialogOpen.value = true
    }
    
    fun closeTaskDialog() {
        _isTaskDialogOpen.value = false
        _editingTask.value = null
    }
    
    fun addTask(title: String, description: String = "", priority: Task.Priority = Task.Priority.MEDIUM) {
        viewModelScope.launch {
            val task = Task(
                title = title,
                description = description,
                priority = priority,
                category = _selectedCategory.value,
                needsSync = true
            )
            taskRepository.insertTask(task)
        }
    }
    
    fun updateTask(task: Task) {
        viewModelScope.launch {
            val updatedTask = task.copy(needsSync = true)
            taskRepository.updateTask(updatedTask)
        }
    }
    
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskRepository.deleteTask(task)
        }
    }
    
    fun toggleTaskCompletion(task: Task) {
        viewModelScope.launch {
            val updatedTask = task.copy(
                isCompleted = !task.isCompleted,
                needsSync = true
            )
            taskRepository.updateTask(updatedTask)
        }
    }
    
    fun updateTaskPomodoros(task: Task, completed: Int) {
        viewModelScope.launch {
            val updatedTask = task.copy(
                pomodorosCompleted = completed,
                needsSync = true
            )
            taskRepository.updateTask(updatedTask)
        }
    }
}

