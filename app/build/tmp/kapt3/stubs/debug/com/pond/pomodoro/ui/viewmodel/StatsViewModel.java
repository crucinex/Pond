package com.pond.pomodoro.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/pond/pomodoro/ui/viewmodel/StatsViewModel;", "Landroidx/lifecycle/ViewModel;", "pomodoroRepository", "Lcom/pond/pomodoro/data/repository/PomodoroRepository;", "(Lcom/pond/pomodoro/data/repository/PomodoroRepository;)V", "_stats", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/pond/pomodoro/ui/viewmodel/StatsData;", "stats", "Lkotlinx/coroutines/flow/StateFlow;", "getStats", "()Lkotlinx/coroutines/flow/StateFlow;", "loadStats", "", "app_debug"})
public final class StatsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.repository.PomodoroRepository pomodoroRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.pond.pomodoro.ui.viewmodel.StatsData> _stats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.pond.pomodoro.ui.viewmodel.StatsData> stats = null;
    
    public StatsViewModel(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.repository.PomodoroRepository pomodoroRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.pond.pomodoro.ui.viewmodel.StatsData> getStats() {
        return null;
    }
    
    public final void loadStats() {
    }
}