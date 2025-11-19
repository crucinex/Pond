package com.pond.pomodoro.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pond.pomodoro.data.dao.PomodoroSessionDao
import com.pond.pomodoro.data.dao.TaskDao
import com.pond.pomodoro.data.model.PomodoroSession
import com.pond.pomodoro.data.model.Task

@Database(
    entities = [Task::class, PomodoroSession::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class PondDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun pomodoroSessionDao(): PomodoroSessionDao
}

