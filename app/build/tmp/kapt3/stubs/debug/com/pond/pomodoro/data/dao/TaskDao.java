package com.pond.pomodoro.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0012\u001a\u00020\u0013H\'J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00a2\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\'J\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/pond/pomodoro/data/dao/TaskDao;", "", "deleteTask", "", "task", "Lcom/pond/pomodoro/data/model/Task;", "(Lcom/pond/pomodoro/data/model/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTaskById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveTasks", "Lkotlinx/coroutines/flow/Flow;", "", "getAllTasks", "getCompletedTasks", "getTaskById", "getTasksByCategory", "category", "", "getTasksNeedingSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodayTasks", "startOfDay", "endOfDay", "insertTask", "updateTask", "app_debug"})
@androidx.room.Dao()
public abstract interface TaskDao {
    
    @androidx.room.Query(value = "SELECT * FROM tasks ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getAllTasks();
    
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE category = :category ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getTasksByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE isCompleted = 0 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getActiveTasks();
    
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE isCompleted = 1 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getCompletedTasks();
    
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTaskById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pond.pomodoro.data.model.Task> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE needsSync = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTasksNeedingSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.pond.pomodoro.data.model.Task>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tasks WHERE dueDate IS NOT NULL AND dueDate >= :startOfDay AND dueDate < :endOfDay AND isCompleted = 0")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getTodayTasks(long startOfDay, long endOfDay);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTask(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM tasks WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTaskById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}