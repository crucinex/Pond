package com.pond.pomodoro.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pond.pomodoro.data.model.PomodoroSession
import com.pond.pomodoro.data.repository.PomodoroRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class TimerState(
    val isRunning: Boolean = false,
    val isPaused: Boolean = false,
    val timeRemaining: Long = 25 * 60 * 1000L, // 25 minutes in milliseconds
    val totalTime: Long = 25 * 60 * 1000L,
    val sessionType: PomodoroSession.SessionType = PomodoroSession.SessionType.FOCUS,
    val currentTaskId: Long? = null,
    val pomodorosCompleted: Int = 0
)

class PomodoroViewModel(
    private val pomodoroRepository: PomodoroRepository
) : ViewModel() {
    
    private val _timerState = MutableStateFlow(TimerState())
    val timerState: StateFlow<TimerState> = _timerState.asStateFlow()
    
    private val _focusDuration = MutableStateFlow(25 * 60 * 1000L)
    val focusDuration: StateFlow<Long> = _focusDuration.asStateFlow()
    
    private val _shortBreakDuration = MutableStateFlow(5 * 60 * 1000L)
    val shortBreakDuration: StateFlow<Long> = _shortBreakDuration.asStateFlow()
    
    private val _longBreakDuration = MutableStateFlow(15 * 60 * 1000L)
    val longBreakDuration: StateFlow<Long> = _longBreakDuration.asStateFlow()
    
    private val _pomodorosUntilLongBreak = MutableStateFlow(4)
    val pomodorosUntilLongBreak: StateFlow<Int> = _pomodorosUntilLongBreak.asStateFlow()
    
    private var timerJob: Job? = null
    
    fun startTimer(taskId: Long? = null) {
        if (_timerState.value.isRunning) return
        
        viewModelScope.launch {
            val currentState = _timerState.value
            val sessionType = if (currentState.timeRemaining == currentState.totalTime) {
                currentState.sessionType
            } else {
                PomodoroSession.SessionType.FOCUS
            }
            
            val duration = when (sessionType) {
                PomodoroSession.SessionType.FOCUS -> _focusDuration.value
                PomodoroSession.SessionType.SHORT_BREAK -> _shortBreakDuration.value
                PomodoroSession.SessionType.LONG_BREAK -> _longBreakDuration.value
            }
            
            _timerState.value = currentState.copy(
                isRunning = true,
                isPaused = false,
                timeRemaining = if (currentState.timeRemaining == currentState.totalTime) duration else currentState.timeRemaining,
                totalTime = duration,
                sessionType = sessionType,
                currentTaskId = taskId ?: currentState.currentTaskId
            )
            
            // Create session
            val session = PomodoroSession(
                taskId = taskId ?: currentState.currentTaskId,
                startTime = System.currentTimeMillis(),
                duration = duration,
                type = sessionType,
                isCompleted = false
            )
            val sessionId = pomodoroRepository.insertSession(session)
            
            timerJob = viewModelScope.launch {
                while (_timerState.value.timeRemaining > 0 && _timerState.value.isRunning) {
                    delay(1000)
                    _timerState.value = _timerState.value.copy(
                        timeRemaining = (_timerState.value.timeRemaining - 1000).coerceAtLeast(0)
                    )
                }
                
                if (_timerState.value.timeRemaining <= 0) {
                    onTimerComplete()
                }
            }
        }
    }
    
    fun pauseTimer() {
        timerJob?.cancel()
        _timerState.value = _timerState.value.copy(
            isRunning = false,
            isPaused = true
        )
    }
    
    fun resetTimer() {
        timerJob?.cancel()
        val sessionType = _timerState.value.sessionType
        val duration = when (sessionType) {
            PomodoroSession.SessionType.FOCUS -> _focusDuration.value
            PomodoroSession.SessionType.SHORT_BREAK -> _shortBreakDuration.value
            PomodoroSession.SessionType.LONG_BREAK -> _longBreakDuration.value
        }
        _timerState.value = _timerState.value.copy(
            isRunning = false,
            isPaused = false,
            timeRemaining = duration,
            totalTime = duration
        )
    }
    
    fun skipTimer() {
        timerJob?.cancel()
        onTimerComplete()
    }
    
    private fun onTimerComplete() {
        viewModelScope.launch {
            val currentState = _timerState.value
            
            // Mark session as completed
            // Note: In a real implementation, you'd update the session with endTime
            
            val nextSessionType = when (currentState.sessionType) {
                PomodoroSession.SessionType.FOCUS -> {
                    val newPomodorosCompleted = currentState.pomodorosCompleted + 1
                    if (newPomodorosCompleted >= _pomodorosUntilLongBreak.value) {
                        PomodoroSession.SessionType.LONG_BREAK
                    } else {
                        PomodoroSession.SessionType.SHORT_BREAK
                    }
                }
                else -> PomodoroSession.SessionType.FOCUS
            }
            
            val pomodorosCompleted = if (currentState.sessionType == PomodoroSession.SessionType.FOCUS) {
                currentState.pomodorosCompleted + 1
            } else {
                currentState.pomodorosCompleted
            }
            
            val duration = when (nextSessionType) {
                PomodoroSession.SessionType.FOCUS -> _focusDuration.value
                PomodoroSession.SessionType.SHORT_BREAK -> _shortBreakDuration.value
                PomodoroSession.SessionType.LONG_BREAK -> _longBreakDuration.value
            }
            
            _timerState.value = currentState.copy(
                isRunning = false,
                isPaused = false,
                timeRemaining = duration,
                totalTime = duration,
                sessionType = nextSessionType,
                pomodorosCompleted = pomodorosCompleted
            )
        }
    }
    
    fun setFocusDuration(minutes: Int) {
        _focusDuration.value = minutes * 60 * 1000L
    }
    
    fun setShortBreakDuration(minutes: Int) {
        _shortBreakDuration.value = minutes * 60 * 1000L
    }
    
    fun setLongBreakDuration(minutes: Int) {
        _longBreakDuration.value = minutes * 60 * 1000L
    }
    
    fun setPomodorosUntilLongBreak(count: Int) {
        _pomodorosUntilLongBreak.value = count
    }
    
    fun selectSessionType(type: PomodoroSession.SessionType) {
        val duration = when (type) {
            PomodoroSession.SessionType.FOCUS -> _focusDuration.value
            PomodoroSession.SessionType.SHORT_BREAK -> _shortBreakDuration.value
            PomodoroSession.SessionType.LONG_BREAK -> _longBreakDuration.value
        }
        _timerState.value = _timerState.value.copy(
            sessionType = type,
            timeRemaining = duration,
            totalTime = duration
        )
    }
}

