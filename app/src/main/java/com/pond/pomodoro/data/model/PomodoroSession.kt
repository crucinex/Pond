package com.pond.pomodoro.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "pomodoro_sessions")
data class PomodoroSession(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val taskId: Long? = null,
    val startTime: Long,
    val endTime: Long? = null,
    val duration: Long, // in milliseconds
    val type: SessionType,
    val isCompleted: Boolean = false,
    val needsSync: Boolean = false
) {
    enum class SessionType {
        FOCUS, SHORT_BREAK, LONG_BREAK
    }
}

