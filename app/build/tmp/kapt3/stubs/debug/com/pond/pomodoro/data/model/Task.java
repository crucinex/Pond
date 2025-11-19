package com.pond.pomodoro.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001?B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0013J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u000fH\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\bH\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\bH\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\t\u0010/\u001a\u00020\fH\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u000fH\u00c6\u0003J\u008a\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0002\u00103J\t\u00104\u001a\u00020\u000fH\u00d6\u0001J\u0013\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000107H\u00d6\u0003J\t\u00108\u001a\u00020\u000fH\u00d6\u0001J\t\u00109\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000fH\u00d6\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015\u00a8\u0006@"}, d2 = {"Lcom/pond/pomodoro/data/model/Task;", "Landroid/os/Parcelable;", "id", "", "title", "", "description", "isCompleted", "", "createdAt", "dueDate", "priority", "Lcom/pond/pomodoro/data/model/Task$Priority;", "category", "pomodorosCompleted", "", "pomodorosEstimated", "calendarEventId", "needsSync", "(JLjava/lang/String;Ljava/lang/String;ZJLjava/lang/Long;Lcom/pond/pomodoro/data/model/Task$Priority;Ljava/lang/String;IILjava/lang/String;Z)V", "getCalendarEventId", "()Ljava/lang/String;", "getCategory", "getCreatedAt", "()J", "getDescription", "getDueDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "()Z", "getNeedsSync", "getPomodorosCompleted", "()I", "getPomodorosEstimated", "getPriority", "()Lcom/pond/pomodoro/data/model/Task$Priority;", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;ZJLjava/lang/Long;Lcom/pond/pomodoro/data/model/Task$Priority;Ljava/lang/String;IILjava/lang/String;Z)Lcom/pond/pomodoro/data/model/Task;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Priority", "app_debug"})
@androidx.room.Entity(tableName = "tasks")
@kotlinx.parcelize.Parcelize()
public final class Task implements android.os.Parcelable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final boolean isCompleted = false;
    private final long createdAt = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long dueDate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.pond.pomodoro.data.model.Task.Priority priority = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    private final int pomodorosCompleted = 0;
    private final int pomodorosEstimated = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String calendarEventId = null;
    private final boolean needsSync = false;
    
    public Task(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean isCompleted, long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long dueDate, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task.Priority priority, @org.jetbrains.annotations.NotNull()
    java.lang.String category, int pomodorosCompleted, int pomodorosEstimated, @org.jetbrains.annotations.Nullable()
    java.lang.String calendarEventId, boolean needsSync) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final boolean isCompleted() {
        return false;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDueDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.data.model.Task.Priority getPriority() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final int getPomodorosCompleted() {
        return 0;
    }
    
    public final int getPomodorosEstimated() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCalendarEventId() {
        return null;
    }
    
    public final boolean getNeedsSync() {
        return false;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.data.model.Task.Priority component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.pond.pomodoro.data.model.Task copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean isCompleted, long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long dueDate, @org.jetbrains.annotations.NotNull()
    com.pond.pomodoro.data.model.Task.Priority priority, @org.jetbrains.annotations.NotNull()
    java.lang.String category, int pomodorosCompleted, int pomodorosEstimated, @org.jetbrains.annotations.Nullable()
    java.lang.String calendarEventId, boolean needsSync) {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
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
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/pond/pomodoro/data/model/Task$Priority;", "", "(Ljava/lang/String;I)V", "LOW", "MEDIUM", "HIGH", "app_debug"})
    public static enum Priority {
        /*public static final*/ LOW /* = new LOW() */,
        /*public static final*/ MEDIUM /* = new MEDIUM() */,
        /*public static final*/ HIGH /* = new HIGH() */;
        
        Priority() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.pond.pomodoro.data.model.Task.Priority> getEntries() {
            return null;
        }
    }
}