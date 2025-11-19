package com.pond.pomodoro.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u001d2\u0006\u0010\'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\nJ\u0006\u0010)\u001a\u00020\u001dJ\u0017\u0010*\u001a\u00020\u001d2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010,R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006-"}, d2 = {"Lcom/pond/pomodoro/ui/viewmodel/PomodoroViewModel;", "Landroidx/lifecycle/ViewModel;", "pomodoroRepository", "Lcom/pond/pomodoro/data/repository/PomodoroRepository;", "(Lcom/pond/pomodoro/data/repository/PomodoroRepository;)V", "_focusDuration", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_longBreakDuration", "_pomodorosUntilLongBreak", "", "_shortBreakDuration", "_timerState", "Lcom/pond/pomodoro/ui/viewmodel/TimerState;", "focusDuration", "Lkotlinx/coroutines/flow/StateFlow;", "getFocusDuration", "()Lkotlinx/coroutines/flow/StateFlow;", "longBreakDuration", "getLongBreakDuration", "pomodorosUntilLongBreak", "getPomodorosUntilLongBreak", "shortBreakDuration", "getShortBreakDuration", "timerJob", "Lkotlinx/coroutines/Job;", "timerState", "getTimerState", "onTimerComplete", "", "pauseTimer", "resetTimer", "selectSessionType", "type", "Lcom/pond/pomodoro/data/model/PomodoroSession$SessionType;", "setFocusDuration", "minutes", "setLongBreakDuration", "setPomodorosUntilLongBreak", "count", "setShortBreakDuration", "skipTimer", "startTimer", "taskId", "(Ljava/lang/Long;)V", "app_debug"})
public final class PomodoroViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.repository.PomodoroRepository pomodoroRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.pond.pomodoro.ui.viewmodel.TimerState> _timerState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.pond.pomodoro.ui.viewmodel.TimerState> timerState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _focusDuration = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> focusDuration = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _shortBreakDuration = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> shortBreakDuration = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _longBreakDuration = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> longBreakDuration = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _pomodorosUntilLongBreak = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> pomodorosUntilLongBreak = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job timerJob;
    
    public PomodoroViewModel(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.repository.PomodoroRepository pomodoroRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.pond.pomodoro.ui.viewmodel.TimerState> getTimerState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getFocusDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getShortBreakDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getLongBreakDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getPomodorosUntilLongBreak() {
        return null;
    }
    
    public final void startTimer(@org.jetbrains.annotations.Nullable()
    java.lang.Long taskId) {
    }
    
    public final void pauseTimer() {
    }
    
    public final void resetTimer() {
    }
    
    public final void skipTimer() {
    }
    
    private final void onTimerComplete() {
    }
    
    public final void setFocusDuration(int minutes) {
    }
    
    public final void setShortBreakDuration(int minutes) {
    }
    
    public final void setLongBreakDuration(int minutes) {
    }
    
    public final void setPomodorosUntilLongBreak(int count) {
    }
    
    public final void selectSessionType(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.PomodoroSession.SessionType type) {
    }
}