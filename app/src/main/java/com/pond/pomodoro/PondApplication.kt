package com.pond.pomodoro

import android.app.Application
import androidx.room.Room
import com.pond.pomodoro.data.database.PondDatabase

class PondApplication : Application() {
    val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            PondDatabase::class.java,
            "pond_database"
        ).build()
    }
}
