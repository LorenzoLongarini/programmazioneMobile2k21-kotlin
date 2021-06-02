package com.example.easycooking.adapter.ricetta;

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
public final class RicettaDAO_Impl implements RicettaDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RicettaDBEntity> __insertionAdapterOfRicettaDBEntity;

  private final EntityDeletionOrUpdateAdapter<RicettaDBEntity> __deletionAdapterOfRicettaDBEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public RicettaDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRicettaDBEntity = new EntityInsertionAdapter<RicettaDBEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `ricetta_table` (`nome_ricetta`,`ingredienti_ricetta`,`tempocott_ricetta`,`photo_ricetta`,`porzioni_ricetta`,`tempoprep_ricetta`,`prep_ricetta`,`tempotot_ricetta`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RicettaDBEntity value) {
        if (value.getNome() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNome());
        }
        if (value.getIngredienti() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIngredienti());
        }
        if (value.getCookTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCookTime());
        }
        if (value.getImage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImage());
        }
        if (value.getPorzioni() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPorzioni());
        }
        if (value.getPrepTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPrepTime());
        }
        if (value.getPreparazione() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPreparazione());
        }
        if (value.getTotalTime() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTotalTime());
        }
      }
    };
    this.__deletionAdapterOfRicettaDBEntity = new EntityDeletionOrUpdateAdapter<RicettaDBEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ricetta_table` WHERE `nome_ricetta` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RicettaDBEntity value) {
        if (value.getNome() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNome());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ricetta_table";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final RicettaDBEntity ricetta, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRicettaDBEntity.insert(ricetta);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final RicettaDBEntity ricetta, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRicettaDBEntity.handle(ricetta);
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
  public Flow<List<RicettaDBEntity>> getAll() {
    final String _sql = "SELECT * FROM ricetta_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"ricetta_table"}, new Callable<List<RicettaDBEntity>>() {
      @Override
      public List<RicettaDBEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome_ricetta");
          final int _cursorIndexOfIngredienti = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredienti_ricetta");
          final int _cursorIndexOfCookTime = CursorUtil.getColumnIndexOrThrow(_cursor, "tempocott_ricetta");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "photo_ricetta");
          final int _cursorIndexOfPorzioni = CursorUtil.getColumnIndexOrThrow(_cursor, "porzioni_ricetta");
          final int _cursorIndexOfPrepTime = CursorUtil.getColumnIndexOrThrow(_cursor, "tempoprep_ricetta");
          final int _cursorIndexOfPreparazione = CursorUtil.getColumnIndexOrThrow(_cursor, "prep_ricetta");
          final int _cursorIndexOfTotalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "tempotot_ricetta");
          final List<RicettaDBEntity> _result = new ArrayList<RicettaDBEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RicettaDBEntity _item;
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpIngredienti;
            if (_cursor.isNull(_cursorIndexOfIngredienti)) {
              _tmpIngredienti = null;
            } else {
              _tmpIngredienti = _cursor.getString(_cursorIndexOfIngredienti);
            }
            final String _tmpCookTime;
            if (_cursor.isNull(_cursorIndexOfCookTime)) {
              _tmpCookTime = null;
            } else {
              _tmpCookTime = _cursor.getString(_cursorIndexOfCookTime);
            }
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            final String _tmpPorzioni;
            if (_cursor.isNull(_cursorIndexOfPorzioni)) {
              _tmpPorzioni = null;
            } else {
              _tmpPorzioni = _cursor.getString(_cursorIndexOfPorzioni);
            }
            final String _tmpPrepTime;
            if (_cursor.isNull(_cursorIndexOfPrepTime)) {
              _tmpPrepTime = null;
            } else {
              _tmpPrepTime = _cursor.getString(_cursorIndexOfPrepTime);
            }
            final String _tmpPreparazione;
            if (_cursor.isNull(_cursorIndexOfPreparazione)) {
              _tmpPreparazione = null;
            } else {
              _tmpPreparazione = _cursor.getString(_cursorIndexOfPreparazione);
            }
            final String _tmpTotalTime;
            if (_cursor.isNull(_cursorIndexOfTotalTime)) {
              _tmpTotalTime = null;
            } else {
              _tmpTotalTime = _cursor.getString(_cursorIndexOfTotalTime);
            }
            _item = new RicettaDBEntity(_tmpNome,_tmpIngredienti,_tmpCookTime,_tmpImage,_tmpPorzioni,_tmpPrepTime,_tmpPreparazione,_tmpTotalTime);
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
