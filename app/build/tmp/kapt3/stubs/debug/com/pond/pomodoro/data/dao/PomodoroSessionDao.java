package com.pond.pomodoro.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0013\u001a\u00020\rH\'J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/pond/pomodoro/data/dao/PomodoroSessionDao;", "", "deleteSession", "", "session", "Lcom/pond/pomodoro/data/model/PomodoroSession;", "(Lcom/pond/pomodoro/data/model/PomodoroSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSessions", "Lkotlinx/coroutines/flow/Flow;", "", "getCompletedPomodorosCount", "", "startTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionsByDate", "startOfDay", "endOfDay", "getSessionsByTask", "taskId", "getSessionsNeedingSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalFocusTime", "insertSession", "updateSession", "app_debug"})
@androidx.room.Dao()
public abstract interface PomodoroSessionDao {
    
    @androidx.room.Query(value = "SELECT * FROM pomodoro_sessions ORDER BY startTime DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> getAllSessions();
    
    @androidx.room.Query(value = "SELECT * FROM pomodoro_sessions WHERE taskId = :taskId ORDER BY startTime DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> getSessionsByTask(long taskId);
    
    @androidx.room.Query(value = "SELECT * FROM pomodoro_sessions WHERE startTime >= :startOfDay AND startTime < :endOfDay")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> getSessionsByDate(long startOfDay, long endOfDay);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM pomodoro_sessions WHERE type = \'FOCUS\' AND isCompleted = 1 AND startTime >= :startTime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompletedPomodorosCount(long startTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(duration) FROM pomodoro_sessions WHERE type = \'FOCUS\' AND isCompleted = 1 AND startTime >= :startTime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalFocusTime(long startTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM pomodoro_sessions WHERE needsSync = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSessionsNeedingSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSession(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}