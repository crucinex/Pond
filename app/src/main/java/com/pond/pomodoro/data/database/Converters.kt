package com.pond.pomodoro.data.database

import androidx.room.TypeConverter
import com.pond.pomodoro.data.model.PomodoroSession
import com.pond.pomodoro.data.model.Task

class Converters {
    @TypeConverter
    fun fromSessionType(value: PomodoroSession.SessionType): String {
        return value.name
    }
    
    @TypeConverter
    fun toSessionType(value: String): PomodoroSession.SessionType {
        return PomodoroSession.SessionType.valueOf(value)
    }
    
    @TypeConverter
    fun fromPriority(value: Task.Priority): String {
        return value.name
    }
    
    @TypeConverter
    fun toPriority(value: String): Task.Priority {
        return Task.Priority.valueOf(value)
    }
}

