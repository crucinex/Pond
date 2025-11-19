package com.pond.pomodoro.ui.screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001aJ\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a$\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001eH\u0007\u001a&\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007\u001a9\u0010\"\u001a\u00020\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0$2\b\u0010%\u001a\u0004\u0018\u00010\u00032\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u001eH\u0007\u00a2\u0006\u0002\u0010\'\u001aP\u0010(\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0007\u001a\u000e\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u00060"}, d2 = {"CircularTimer", "", "timeRemaining", "", "totalTime", "sessionType", "Lcom/pond/pomodoro/data/model/PomodoroSession$SessionType;", "isRunning", "", "PomodoroScreen", "pomodoroViewModel", "Lcom/pond/pomodoro/ui/viewmodel/PomodoroViewModel;", "taskViewModel", "Lcom/pond/pomodoro/ui/viewmodel/TaskViewModel;", "SessionTypeButton", "type", "label", "", "isSelected", "onClick", "Lkotlin/Function0;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "SessionTypeButton-jzV_Hc0", "(Lcom/pond/pomodoro/data/model/PomodoroSession$SessionType;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;JLandroidx/compose/ui/Modifier;)V", "SessionTypeSelector", "currentType", "onTypeSelected", "Lkotlin/Function1;", "TaskItem", "task", "Lcom/pond/pomodoro/data/model/Task;", "TaskSelector", "tasks", "", "selectedTaskId", "onTaskSelected", "(Ljava/util/List;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "TimerControls", "isPaused", "onStart", "onPause", "onReset", "onSkip", "formatTime", "milliseconds", "app_debug"})
public final class PomodoroScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void PomodoroScreen(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.ui.viewmodel.PomodoroViewModel pomodoroViewModel, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.ui.viewmodel.TaskViewModel taskViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SessionTypeSelector(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession.SessionType currentType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.pond.pomodoro.data.model.PomodoroSession.SessionType, kotlin.Unit> onTypeSelected) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CircularTimer(long timeRemaining, long totalTime, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession.SessionType sessionType, boolean isRunning) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TimerControls(boolean isRunning, boolean isPaused, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStart, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPause, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onReset, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkip) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TaskSelector(@org.jetbrains.annotations.NotNull()
    java.util.List<com.pond.pomodoro.data.model.Task> tasks, @org.jetbrains.annotations.Nullable()
    java.lang.Long selectedTaskId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onTaskSelected) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void TaskItem(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task task, boolean isSelected, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatTime(long milliseconds) {
        return null;
    }
}