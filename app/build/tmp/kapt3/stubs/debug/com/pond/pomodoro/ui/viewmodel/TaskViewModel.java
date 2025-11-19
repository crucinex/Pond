package com.pond.pomodoro.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020!J\u000e\u0010\'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0007J\u0012\u0010)\u001a\u00020!2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0007J\u0016\u0010.\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010/\u001a\u000200R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010\u00a8\u00061"}, d2 = {"Lcom/pond/pomodoro/ui/viewmodel/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/pond/pomodoro/data/repository/TaskRepository;", "(Lcom/pond/pomodoro/data/repository/TaskRepository;)V", "_editingTask", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/pond/pomodoro/data/model/Task;", "_isTaskDialogOpen", "", "_selectedCategory", "", "activeTasks", "Lkotlinx/coroutines/flow/Flow;", "", "getActiveTasks", "()Lkotlinx/coroutines/flow/Flow;", "completedTasks", "getCompletedTasks", "editingTask", "Lkotlinx/coroutines/flow/StateFlow;", "getEditingTask", "()Lkotlinx/coroutines/flow/StateFlow;", "inboxTasks", "getInboxTasks", "isTaskDialogOpen", "selectedCategory", "getSelectedCategory", "tasks", "getTasks", "todayTasks", "getTodayTasks", "addTask", "", "title", "description", "priority", "Lcom/pond/pomodoro/data/model/Task$Priority;", "closeTaskDialog", "deleteTask", "task", "openTaskDialog", "selectCategory", "category", "toggleTaskCompletion", "updateTask", "updateTaskPomodoros", "completed", "", "app_debug"})
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.repository.TaskRepository taskRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> tasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> activeTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> completedTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> todayTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> inboxTasks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isTaskDialogOpen = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isTaskDialogOpen = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.pond.pomodoro.data.model.Task> _editingTask = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.pond.pomodoro.data.model.Task> editingTask = null;
    
    public TaskViewModel(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.repository.TaskRepository taskRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getActiveTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getCompletedTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getTodayTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.pond.pomodoro.data.model.Task>> getInboxTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isTaskDialogOpen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.pond.pomodoro.data.model.Task> getEditingTask() {
        return null;
    }
    
    public final void selectCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    public final void openTaskDialog(@org.jetbrains.annotations.Nullable()
    com.pond.pomodoro.data.model.Task task) {
    }
    
    public final void closeTaskDialog() {
    }
    
    public final void addTask(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task.Priority priority) {
    }
    
    public final void updateTask(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task) {
    }
    
    public final void deleteTask(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task) {
    }
    
    public final void toggleTaskCompletion(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task) {
    }
    
    public final void updateTaskPomodoros(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, int completed) {
    }
}