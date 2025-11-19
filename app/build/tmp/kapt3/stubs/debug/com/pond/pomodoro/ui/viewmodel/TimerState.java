package com.pond.pomodoro.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\fH\u00c6\u0003JV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001\u00a2\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\fH\u00d6\u0001J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006\'"}, d2 = {"Lcom/pond/pomodoro/ui/viewmodel/TimerState;", "", "isRunning", "", "isPaused", "timeRemaining", "", "totalTime", "sessionType", "Lcom/pond/pomodoro/data/model/PomodoroSession$SessionType;", "currentTaskId", "pomodorosCompleted", "", "(ZZJJLcom/pond/pomodoro/data/model/PomodoroSession$SessionType;Ljava/lang/Long;I)V", "getCurrentTaskId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getPomodorosCompleted", "()I", "getSessionType", "()Lcom/pond/pomodoro/data/model/PomodoroSession$SessionType;", "getTimeRemaining", "()J", "getTotalTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZZJJLcom/pond/pomodoro/data/model/PomodoroSession$SessionType;Ljava/lang/Long;I)Lcom/pond/pomodoro/ui/viewmodel/TimerState;", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class TimerState {
    private final boolean isRunning = false;
    private final boolean isPaused = false;
    private final long timeRemaining = 0L;
    private final long totalTime = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.model.PomodoroSession.SessionType sessionType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long currentTaskId = null;
    private final int pomodorosCompleted = 0;
    
    public TimerState(boolean isRunning, boolean isPaused, long timeRemaining, long totalTime, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession.SessionType sessionType, @org.jetbrains.annotations.Nullable()
    java.lang.Long currentTaskId, int pomodorosCompleted) {
        super();
    }
    
    public final boolean isRunning() {
        return false;
    }
    
    public final boolean isPaused() {
        return false;
    }
    
    public final long getTimeRemaining() {
        return 0L;
    }
    
    public final long getTotalTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.data.model.PomodoroSession.SessionType getSessionType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCurrentTaskId() {
        return null;
    }
    
    public final int getPomodorosCompleted() {
        return 0;
    }
    
    public TimerState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.data.model.PomodoroSession.SessionType component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.ui.viewmodel.TimerState copy(boolean isRunning, boolean isPaused, long timeRemaining, long totalTime, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession.SessionType sessionType, @org.jetbrains.annotations.Nullable()
    java.lang.Long currentTaskId, int pomodorosCompleted) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}