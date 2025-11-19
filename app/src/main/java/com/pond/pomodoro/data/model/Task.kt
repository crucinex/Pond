package com.pond.pomodoro.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import java.util.Date

@Entity(tableName = "tasks")
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val dueDate: Long? = null,
    val priority: Priority = Priority.MEDIUM,
    val category: String = "inbox",
    val pomodorosCompleted: Int = 0,
    val pomodorosEstimated: Int = 1,
    val calendarEventId: String? = null,
    val needsSync: Boolean = false
) : Parcelable {
    enum class Priority {
        LOW, MEDIUM, HIGH
    }
}

