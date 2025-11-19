package com.pond.pomodoro.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pond.pomodoro.data.repository.PomodoroRepository
import com.pond.pomodoro.data.repository.TaskRepository

class ViewModelFactory(
    private val taskRepository: TaskRepository,
    private val pomodoroRepository: PomodoroRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PomodoroViewModel::class.java)) {
            return PomodoroViewModel(pomodoroRepository) as T
        }
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(taskRepository) as T
        }
        if (modelClass.isAssignableFrom(StatsViewModel::class.java)) {
            return StatsViewModel(pomodoroRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}