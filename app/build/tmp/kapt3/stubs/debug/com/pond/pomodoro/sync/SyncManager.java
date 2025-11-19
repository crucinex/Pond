package com.pond.pomodoro.sync;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/pond/pomodoro/sync/SyncManager;", "", "context", "Landroid/content/Context;", "taskRepository", "Lcom/pond/pomodoro/data/repository/TaskRepository;", "pomodoroRepository", "Lcom/pond/pomodoro/data/repository/PomodoroRepository;", "calendarSyncService", "Lcom/pond/pomodoro/sync/CalendarSyncService;", "(Landroid/content/Context;Lcom/pond/pomodoro/data/repository/TaskRepository;Lcom/pond/pomodoro/data/repository/PomodoroRepository;Lcom/pond/pomodoro/sync/CalendarSyncService;)V", "cancelPeriodicSync", "", "enableAutoSync", "enabled", "", "schedulePeriodicSync", "syncNow", "Lcom/pond/pomodoro/sync/SyncManager$SyncResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SyncResult", "app_debug"})
public final class SyncManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.repository.TaskRepository taskRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.repository.PomodoroRepository pomodoroRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.sync.CalendarSyncService calendarSyncService = null;
    
    public SyncManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.repository.TaskRepository taskRepository, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.repository.PomodoroRepository pomodoroRepository, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.sync.CalendarSyncService calendarSyncService) {
        super();
    }
    
    public final void enableAutoSync(boolean enabled) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncNow(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.pond.pomodoro.sync.SyncManager.SyncResult> $completion) {
        return null;
    }
    
    private final void schedulePeriodicSync() {
    }
    
    private final void cancelPeriodicSync() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/pond/pomodoro/sync/SyncManager$SyncResult;", "", "tasksSynced", "", "sessionsSynced", "errors", "(III)V", "getErrors", "()I", "getSessionsSynced", "getTasksSynced", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class SyncResult {
        private final int tasksSynced = 0;
        private final int sessionsSynced = 0;
        private final int errors = 0;
        
        public SyncResult(int tasksSynced, int sessionsSynced, int errors) {
            super();
        }
        
        public final int getTasksSynced() {
            return 0;
        }
        
        public final int getSessionsSynced() {
            return 0;
        }
        
        public final int getErrors() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.pond.pomodoro.sync.SyncManager.SyncResult copy(int tasksSynced, int sessionsSynced, int errors) {
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
}