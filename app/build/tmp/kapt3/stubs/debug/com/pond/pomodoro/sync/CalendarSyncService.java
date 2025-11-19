package com.pond.pomodoro.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/pond/pomodoro/sync/CalendarSyncService;", "", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;)V", "createCalendarEvent", "", "task", "Lcom/pond/pomodoro/data/model/Task;", "(Lcom/pond/pomodoro/data/model/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCalendarEvent", "", "eventId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultCalendarId", "", "getPriorityColor", "", "priority", "Lcom/pond/pomodoro/data/model/Task$Priority;", "updateCalendarEvent", "app_debug"})
public final class CalendarSyncService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.ContentResolver contentResolver = null;
    
    public CalendarSyncService(@org.jetbrains.annotations.NotNull()
    android.content.ContentResolver contentResolver) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createCalendarEvent(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateCalendarEvent(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteCalendarEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final long getDefaultCalendarId() {
        return 0L;
    }
    
    private final int getPriorityColor(com.pond.pomodoro.data.model.Task.Priority priority) {
        return 0;
    }
}