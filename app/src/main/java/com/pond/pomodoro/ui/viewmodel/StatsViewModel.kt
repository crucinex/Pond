package com.pond.pomodoro.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pond.pomodoro.data.repository.PomodoroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

data class StatsData(
    val totalPomodoros: Int = 0,
    val todayPomodoros: Int = 0,
    val weekPomodoros: Int = 0,
    val monthPomodoros: Int = 0,
    val totalFocusTime: Long = 0L,
    val todayFocusTime: Long = 0L,
    val weekFocusTime: Long = 0L,
    val monthFocusTime: Long = 0L
)

class StatsViewModel(
    private val pomodoroRepository: PomodoroRepository
) : ViewModel() {
    
    private val _stats = MutableStateFlow(StatsData())
    val stats: StateFlow<StatsData> = _stats.asStateFlow()
    
    init {
        loadStats()
    }
    
    fun loadStats() {
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            
            // Today
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            val todayStart = calendar.timeInMillis
            
            // Week
            calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)
            val weekStart = calendar.timeInMillis
            
            // Month
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            val monthStart = calendar.timeInMillis
            
            // All time
            val allTimeStart = 0L
            
            val todayPomodoros = pomodoroRepository.getCompletedPomodorosCount(todayStart)
            val weekPomodoros = pomodoroRepository.getCompletedPomodorosCount(weekStart)
            val monthPomodoros = pomodoroRepository.getCompletedPomodorosCount(monthStart)
            val totalPomodoros = pomodoroRepository.getCompletedPomodorosCount(allTimeStart)
            
            val todayFocusTime = pomodoroRepository.getTotalFocusTime(todayStart) ?: 0L
            val weekFocusTime = pomodoroRepository.getTotalFocusTime(weekStart) ?: 0L
            val monthFocusTime = pomodoroRepository.getTotalFocusTime(monthStart) ?: 0L
            val totalFocusTime = pomodoroRepository.getTotalFocusTime(allTimeStart) ?: 0L
            
            _stats.value = StatsData(
                totalPomodoros = totalPomodoros,
                todayPomodoros = todayPomodoros,
                weekPomodoros = weekPomodoros,
                monthPomodoros = monthPomodoros,
                totalFocusTime = totalFocusTime,
                todayFocusTime = todayFocusTime,
                weekFocusTime = weekFocusTime,
                monthFocusTime = monthFocusTime
            )
        }
    }
}

