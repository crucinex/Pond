package com.pond.pomodoro.ui.screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u001a \u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007\u00a8\u0006\u0011"}, d2 = {"StatCard", "", "title", "", "pomodoros", "", "focusTime", "", "StatItem", "label", "value", "icon", "StatsScreen", "statsViewModel", "Lcom/pond/pomodoro/ui/viewmodel/StatsViewModel;", "formatFocusTime", "milliseconds", "app_debug"})
public final class StatsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void StatsScreen(@org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.ui.viewmodel.StatsViewModel statsViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatCard(@org.jetbrains.annotations.NotNull()
    java.lang.String title, int pomodoros, long focusTime) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatItem(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    java.lang.String icon) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatFocusTime(long milliseconds) {
        return null;
    }
}