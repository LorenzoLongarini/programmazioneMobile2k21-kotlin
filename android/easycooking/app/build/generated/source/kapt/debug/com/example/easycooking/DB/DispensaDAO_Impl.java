package com.example.easycooking.DB;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DispensaDAO_Impl implements DispensaDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DispensaDBEntity> __insertionAdapterOfDispensaDBEntity;

  private final EntityDeletionOrUpdateAdapter<DispensaDBEntity> __deletionAdapterOfDispensaDBEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DispensaDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDispensaDBEntity = new EntityInsertionAdapter<DispensaDBEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `dispensa_table` (`nome_prodotto`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DispensaDBEntity value) {
        if (value.getNomeProdotto() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNomeProdotto());
        }
      }
    };
    this.__deletionAdapterOfDispensaDBEntity = new EntityDeletionOrUpdateAdapter<DispensaDBEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `dispensa_table` WHERE `nome_prodotto` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DispensaDBEntity value) {
        if (value.getNomeProdotto() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNomeProdotto());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM dispensa_table";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final DispensaDBEntity dispensa, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDispensaDBEntity.insert(dispensa);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final DispensaDBEntity dispensa, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDispensaDBEntity.handle(dispensa);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Flow<List<DispensaDBEntity>> getAll() {
    final String _sql = "SELECT * FROM dispensa_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"dispensa_table"}, new Callable<List<DispensaDBEntity>>() {
      @Override
      public List<DispensaDBEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNomeProdotto = CursorUtil.getColumnIndexOrThrow(_cursor, "nome_prodotto");
          final List<DispensaDBEntity> _result = new ArrayList<DispensaDBEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DispensaDBEntity _item;
            final String _tmpNomeProdotto;
            if (_cursor.isNull(_cursorIndexOfNomeProdotto)) {
              _tmpNomeProdotto = null;
            } else {
              _tmpNomeProdotto = _cursor.getString(_cursorIndexOfNomeProdotto);
            }
            _item = new DispensaDBEntity(_tmpNomeProdotto);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
