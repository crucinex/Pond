package com.pond.pomodoro.sync

import android.content.ContentResolver
import android.content.ContentUris
import android.content.ContentValues
import android.net.Uri
import android.provider.CalendarContract
import android.util.Log
import com.pond.pomodoro.data.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CalendarSyncService(private val contentResolver: ContentResolver) {
    
    suspend fun createCalendarEvent(task: Task): String? = withContext(Dispatchers.IO) {
        try {
            val values = ContentValues().apply {
                put(CalendarContract.Events.DTSTART, task.dueDate ?: System.currentTimeMillis())
                put(CalendarContract.Events.DTEND, (task.dueDate ?: System.currentTimeMillis()) + 3600000) // 1 hour default
                put(CalendarContract.Events.TITLE, task.title)
                put(CalendarContract.Events.DESCRIPTION, task.description)
                put(CalendarContract.Events.CALENDAR_ID, getDefaultCalendarId())
                put(CalendarContract.Events.EVENT_TIMEZONE, java.util.TimeZone.getDefault().id)
                put(CalendarContract.Events.EVENT_COLOR, getPriorityColor(task.priority))
            }
            
            val uri: Uri? = contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)
            uri?.lastPathSegment?.let { eventId ->
                Log.d("CalendarSync", "Created calendar event: $eventId for task: ${task.title}")
                return@withContext eventId
            }
            null
        } catch (e: SecurityException) {
            Log.e("CalendarSync", "Permission denied for calendar access", e)
            null
        } catch (e: Exception) {
            Log.e("CalendarSync", "Error creating calendar event", e)
            null
        }
    }
    
    suspend fun updateCalendarEvent(task: Task): Boolean = withContext(Dispatchers.IO) {
        if (task.calendarEventId == null) return@withContext false
        
        try {
            val values = ContentValues().apply {
                put(CalendarContract.Events.TITLE, task.title)
                put(CalendarContract.Events.DESCRIPTION, task.description)
                if (task.dueDate != null) {
                    put(CalendarContract.Events.DTSTART, task.dueDate)
                    put(CalendarContract.Events.DTEND, task.dueDate + 3600000)
                }
                put(CalendarContract.Events.EVENT_COLOR, getPriorityColor(task.priority))
            }
            
            val uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, task.calendarEventId.toLong())
            val rowsUpdated = contentResolver.update(uri, values, null, null)
            Log.d("CalendarSync", "Updated calendar event: ${task.calendarEventId}, rows: $rowsUpdated")
            rowsUpdated > 0
        } catch (e: SecurityException) {
            Log.e("CalendarSync", "Permission denied for calendar update", e)
            false
        } catch (e: Exception) {
            Log.e("CalendarSync", "Error updating calendar event", e)
            false
        }
    }
    
    suspend fun deleteCalendarEvent(eventId: String): Boolean = withContext(Dispatchers.IO) {
        try {
            val uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, eventId.toLong())
            val rowsDeleted = contentResolver.delete(uri, null, null)
            Log.d("CalendarSync", "Deleted calendar event: $eventId, rows: $rowsDeleted")
            rowsDeleted > 0
        } catch (e: SecurityException) {
            Log.e("CalendarSync", "Permission denied for calendar delete", e)
            false
        } catch (e: Exception) {
            Log.e("CalendarSync", "Error deleting calendar event", e)
            false
        }
    }
    
    private fun getDefaultCalendarId(): Long {
        val projection = arrayOf(CalendarContract.Calendars._ID)
        val selection = "${CalendarContract.Calendars.VISIBLE} = ?"
        val selectionArgs = arrayOf("1")
        
        return try {
            contentResolver.query(
                CalendarContract.Calendars.CONTENT_URI,
                projection,
                selection,
                selectionArgs,
                null
            )?.use { cursor ->
                if (cursor.moveToFirst()) {
                    cursor.getLong(0)
                } else {
                    1L // Default fallback
                }
            } ?: 1L
        } catch (e: Exception) {
            Log.e("CalendarSync", "Error getting default calendar ID", e)
            1L
        }
    }
    
    private fun getPriorityColor(priority: Task.Priority): Int {
        return when (priority) {
            Task.Priority.HIGH -> 0xFFEF4444.toInt()
            Task.Priority.MEDIUM -> 0xFFF59E0B.toInt()
            Task.Priority.LOW -> 0xFF10B981.toInt()
        }
    }
}

