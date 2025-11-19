package com.pond.pomodoro.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u000f\u001a\u00020\fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/pond/pomodoro/data/repository/PomodoroRepository;", "", "sessionDao", "Lcom/pond/pomodoro/data/dao/PomodoroSessionDao;", "(Lcom/pond/pomodoro/data/dao/PomodoroSessionDao;)V", "getAllSessions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/pond/pomodoro/data/model/PomodoroSession;", "getCompletedPomodorosCount", "", "startTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionsByTask", "taskId", "getSessionsNeedingSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodaySessions", "getTotalFocusTime", "insertSession", "session", "(Lcom/pond/pomodoro/data/model/PomodoroSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSession", "", "app_debug"})
public final class PomodoroRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.dao.PomodoroSessionDao sessionDao = null;
    
    public PomodoroRepository(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.dao.PomodoroSessionDao sessionDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> getAllSessions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> getSessionsByTask(long taskId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCompletedPomodorosCount(long startTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTotalFocusTime(long startTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSessionsNeedingSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.PomodoroSession>> getTodaySessions() {
        return null;
    }
}