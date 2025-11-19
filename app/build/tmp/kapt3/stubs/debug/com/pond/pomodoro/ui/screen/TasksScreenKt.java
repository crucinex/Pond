package com.pond.pomodoro.ui.screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a$\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a:\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007\u001a@\u0010\u0014\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0017H\u0007\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u00a8\u0006\u001b"}, d2 = {"CategoryTabs", "", "selectedCategory", "", "onCategorySelected", "Lkotlin/Function1;", "EmptyTasksView", "PriorityIndicator", "priority", "Lcom/pond/pomodoro/data/model/Task$Priority;", "PrioritySelector", "selectedPriority", "onPrioritySelected", "TaskCard", "task", "Lcom/pond/pomodoro/data/model/Task;", "onToggleComplete", "Lkotlin/Function0;", "onDelete", "onEdit", "TaskDialog", "onDismiss", "onSave", "Lkotlin/Function3;", "TasksScreen", "taskViewModel", "Lcom/pond/pomodoro/ui/viewmodel/TaskViewModel;", "app_debug"})
public final class TasksScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void TasksScreen(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.ui.viewmodel.TaskViewModel taskViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CategoryTabs(@org.jetbrains.annotations.NotNull()
    java.lang.String selectedCategory, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCategorySelected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TaskCard(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleComplete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PriorityIndicator(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task.Priority priority) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyTasksView() {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void TaskDialog(@org.jetbrains.annotations.Nullable()
    com.pond.pomodoro.data.model.Task task, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super com.pond.pomodoro.data.model.Task.Priority, kotlin.Unit> onSave) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PrioritySelector(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task.Priority selectedPriority, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.pond.pomodoro.data.model.Task.Priority, kotlin.Unit> onPrioritySelected) {
    }
}