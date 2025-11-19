package com.pond.pomodoro.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/pond/pomodoro/data/database/PondDatabase;", "Landroidx/room/RoomDatabase;", "()V", "pomodoroSessionDao", "Lcom/pond/pomodoro/data/dao/PomodoroSessionDao;", "taskDao", "Lcom/pond/pomodoro/data/dao/TaskDao;", "app_debug"})
@androidx.room.Database(entities = {com.pond.pomodoro.data.model.Task.class, com.pond.pomodoro.data.model.PomodoroSession.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.pond.pomodoro.data.database.Converters.class})
public abstract class PondDatabase extends androidx.room.RoomDatabase {
    
    public PondDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pond.pomodoro.data.dao.TaskDao taskDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.pond.pomodoro.data.dao.PomodoroSessionDao pomodoroSessionDao();
}