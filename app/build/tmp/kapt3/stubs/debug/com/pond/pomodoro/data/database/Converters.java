package com.pond.pomodoro.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/pond/pomodoro/data/database/Converters;", "", "()V", "fromPriority", "", "value", "Lcom/pond/pomodoro/data/model/Task$Priority;", "fromSessionType", "Lcom/pond/pomodoro/data/model/PomodoroSession$SessionType;", "toPriority", "toSessionType", "app_debug"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromSessionType(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession.SessionType value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.data.model.PomodoroSession.SessionType toSessionType(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromPriority(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task.Priority value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.data.model.Task.Priority toPriority(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
}