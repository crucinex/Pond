package com.pond.pomodoro.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pond.pomodoro.data.database.Converters;
import com.pond.pomodoro.data.model.PomodoroSession;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PomodoroSessionDao_Impl implements PomodoroSessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PomodoroSession> __insertionAdapterOfPomodoroSession;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<PomodoroSession> __deletionAdapterOfPomodoroSession;

  private final EntityDeletionOrUpdateAdapter<PomodoroSession> __updateAdapterOfPomodoroSession;

  public PomodoroSessionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPomodoroSession = new EntityInsertionAdapter<PomodoroSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pomodoro_sessions` (`id`,`taskId`,`startTime`,`endTime`,`duration`,`type`,`isCompleted`,`needsSync`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PomodoroSession entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTaskId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getTaskId());
        }
        statement.bindLong(3, entity.getStartTime());
        if (entity.getEndTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getEndTime());
        }
        statement.bindLong(5, entity.getDuration());
        final String _tmp = __converters.fromSessionType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        final int _tmp_1 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(7, _tmp_1);
        final int _tmp_2 = entity.getNeedsSync() ? 1 : 0;
        statement.bindLong(8, _tmp_2);
      }
    };
    this.__deletionAdapterOfPomodoroSession = new EntityDeletionOrUpdateAdapter<PomodoroSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `pomodoro_sessions` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PomodoroSession entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfPomodoroSession = new EntityDeletionOrUpdateAdapter<PomodoroSession>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `pomodoro_sessions` SET `id` = ?,`taskId` = ?,`startTime` = ?,`endTime` = ?,`duration` = ?,`type` = ?,`isCompleted` = ?,`needsSync` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PomodoroSession entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTaskId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getTaskId());
        }
        statement.bindLong(3, entity.getStartTime());
        if (entity.getEndTime() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getEndTime());
        }
        statement.bindLong(5, entity.getDuration());
        final String _tmp = __converters.fromSessionType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        final int _tmp_1 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(7, _tmp_1);
        final int _tmp_2 = entity.getNeedsSync() ? 1 : 0;
        statement.bindLong(8, _tmp_2);
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public Object insertSession(final PomodoroSession session,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPomodoroSession.insertAndReturnId(session);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSession(final PomodoroSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPomodoroSession.handle(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSession(final PomodoroSession session,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPomodoroSession.handle(session);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PomodoroSession>> getAllSessions() {
    final String _sql = "SELECT * FROM pomodoro_sessions ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pomodoro_sessions"}, new Callable<List<PomodoroSession>>() {
      @Override
      @NonNull
      public List<PomodoroSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfNeedsSync = CursorUtil.getColumnIndexOrThrow(_cursor, "needsSync");
          final List<PomodoroSession> _result = new ArrayList<PomodoroSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PomodoroSession _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpTaskId;
            if (_cursor.isNull(_cursorIndexOfTaskId)) {
              _tmpTaskId = null;
            } else {
              _tmpTaskId = _cursor.getLong(_cursorIndexOfTaskId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final PomodoroSession.SessionType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toSessionType(_tmp);
            final boolean _tmpIsCompleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_1 != 0;
            final boolean _tmpNeedsSync;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfNeedsSync);
            _tmpNeedsSync = _tmp_2 != 0;
            _item = new PomodoroSession(_tmpId,_tmpTaskId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpType,_tmpIsCompleted,_tmpNeedsSync);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<PomodoroSession>> getSessionsByTask(final long taskId) {
    final String _sql = "SELECT * FROM pomodoro_sessions WHERE taskId = ? ORDER BY startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, taskId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pomodoro_sessions"}, new Callable<List<PomodoroSession>>() {
      @Override
      @NonNull
      public List<PomodoroSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfNeedsSync = CursorUtil.getColumnIndexOrThrow(_cursor, "needsSync");
          final List<PomodoroSession> _result = new ArrayList<PomodoroSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PomodoroSession _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpTaskId;
            if (_cursor.isNull(_cursorIndexOfTaskId)) {
              _tmpTaskId = null;
            } else {
              _tmpTaskId = _cursor.getLong(_cursorIndexOfTaskId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final PomodoroSession.SessionType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toSessionType(_tmp);
            final boolean _tmpIsCompleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_1 != 0;
            final boolean _tmpNeedsSync;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfNeedsSync);
            _tmpNeedsSync = _tmp_2 != 0;
            _item = new PomodoroSession(_tmpId,_tmpTaskId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpType,_tmpIsCompleted,_tmpNeedsSync);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<PomodoroSession>> getSessionsByDate(final long startOfDay, final long endOfDay) {
    final String _sql = "SELECT * FROM pomodoro_sessions WHERE startTime >= ? AND startTime < ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startOfDay);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endOfDay);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pomodoro_sessions"}, new Callable<List<PomodoroSession>>() {
      @Override
      @NonNull
      public List<PomodoroSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfNeedsSync = CursorUtil.getColumnIndexOrThrow(_cursor, "needsSync");
          final List<PomodoroSession> _result = new ArrayList<PomodoroSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PomodoroSession _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpTaskId;
            if (_cursor.isNull(_cursorIndexOfTaskId)) {
              _tmpTaskId = null;
            } else {
              _tmpTaskId = _cursor.getLong(_cursorIndexOfTaskId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final PomodoroSession.SessionType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toSessionType(_tmp);
            final boolean _tmpIsCompleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_1 != 0;
            final boolean _tmpNeedsSync;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfNeedsSync);
            _tmpNeedsSync = _tmp_2 != 0;
            _item = new PomodoroSession(_tmpId,_tmpTaskId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpType,_tmpIsCompleted,_tmpNeedsSync);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getCompletedPomodorosCount(final long startTime,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM pomodoro_sessions WHERE type = 'FOCUS' AND isCompleted = 1 AND startTime >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startTime);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTotalFocusTime(final long startTime,
      final Continuation<? super Long> $completion) {
    final String _sql = "SELECT SUM(duration) FROM pomodoro_sessions WHERE type = 'FOCUS' AND isCompleted = 1 AND startTime >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startTime);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getSessionsNeedingSync(
      final Continuation<? super List<PomodoroSession>> $completion) {
    final String _sql = "SELECT * FROM pomodoro_sessions WHERE needsSync = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PomodoroSession>>() {
      @Override
      @NonNull
      public List<PomodoroSession> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfNeedsSync = CursorUtil.getColumnIndexOrThrow(_cursor, "needsSync");
          final List<PomodoroSession> _result = new ArrayList<PomodoroSession>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PomodoroSession _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final Long _tmpTaskId;
            if (_cursor.isNull(_cursorIndexOfTaskId)) {
              _tmpTaskId = null;
            } else {
              _tmpTaskId = _cursor.getLong(_cursorIndexOfTaskId);
            }
            final long _tmpStartTime;
            _tmpStartTime = _cursor.getLong(_cursorIndexOfStartTime);
            final Long _tmpEndTime;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmpEndTime = null;
            } else {
              _tmpEndTime = _cursor.getLong(_cursorIndexOfEndTime);
            }
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final PomodoroSession.SessionType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toSessionType(_tmp);
            final boolean _tmpIsCompleted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_1 != 0;
            final boolean _tmpNeedsSync;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfNeedsSync);
            _tmpNeedsSync = _tmp_2 != 0;
            _item = new PomodoroSession(_tmpId,_tmpTaskId,_tmpStartTime,_tmpEndTime,_tmpDuration,_tmpType,_tmpIsCompleted,_tmpNeedsSync);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
