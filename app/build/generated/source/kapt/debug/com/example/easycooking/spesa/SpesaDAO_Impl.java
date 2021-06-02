package com.example.easycooking.spesa;

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
public final class SpesaDAO_Impl implements SpesaDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SpesaDBEntity> __insertionAdapterOfSpesaDBEntity;

  private final EntityDeletionOrUpdateAdapter<SpesaDBEntity> __deletionAdapterOfSpesaDBEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SpesaDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSpesaDBEntity = new EntityInsertionAdapter<SpesaDBEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `spesa_table` (`nome_prodotto`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SpesaDBEntity value) {
        if (value.getNomeProdotto() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNomeProdotto());
        }
      }
    };
    this.__deletionAdapterOfSpesaDBEntity = new EntityDeletionOrUpdateAdapter<SpesaDBEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `spesa_table` WHERE `nome_prodotto` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SpesaDBEntity value) {
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
        final String _query = "DELETE FROM spesa_table";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final SpesaDBEntity itemSpesa, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSpesaDBEntity.insert(itemSpesa);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final SpesaDBEntity spesa, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSpesaDBEntity.handle(spesa);
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
  public Flow<List<SpesaDBEntity>> getAll() {
    final String _sql = "SELECT * FROM spesa_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"spesa_table"}, new Callable<List<SpesaDBEntity>>() {
      @Override
      public List<SpesaDBEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNomeProdotto = CursorUtil.getColumnIndexOrThrow(_cursor, "nome_prodotto");
          final List<SpesaDBEntity> _result = new ArrayList<SpesaDBEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SpesaDBEntity _item;
            final String _tmpNomeProdotto;
            if (_cursor.isNull(_cursorIndexOfNomeProdotto)) {
              _tmpNomeProdotto = null;
            } else {
              _tmpNomeProdotto = _cursor.getString(_cursorIndexOfNomeProdotto);
            }
            _item = new SpesaDBEntity(_tmpNomeProdotto);
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
