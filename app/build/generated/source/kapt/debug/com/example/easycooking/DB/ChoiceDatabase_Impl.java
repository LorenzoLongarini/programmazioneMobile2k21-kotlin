package com.example.easycooking.DB;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.easycooking.adapter.ricetta.RicettaDAO;
import com.example.easycooking.adapter.ricetta.RicettaDAO_Impl;
import com.example.easycooking.spesa.SpesaDAO;
import com.example.easycooking.spesa.SpesaDAO_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChoiceDatabase_Impl extends ChoiceDatabase {
  private volatile DispensaDAO _dispensaDAO;

  private volatile SpesaDAO _spesaDAO;

  private volatile RicettaDAO _ricettaDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(6) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dispensa_table` (`nome_prodotto` TEXT NOT NULL, PRIMARY KEY(`nome_prodotto`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `spesa_table` (`nome_prodotto` TEXT NOT NULL, PRIMARY KEY(`nome_prodotto`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ricetta_table` (`nome_ricetta` TEXT NOT NULL, `ingredienti_ricetta` TEXT NOT NULL, `tempocott_ricetta` TEXT NOT NULL, `photo_ricetta` TEXT, `porzioni_ricetta` TEXT NOT NULL, `tempoprep_ricetta` TEXT NOT NULL, `prep_ricetta` TEXT NOT NULL, `tempotot_ricetta` TEXT, PRIMARY KEY(`nome_ricetta`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5ec5558777ff60a78ec027ae5a689c15')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `dispensa_table`");
        _db.execSQL("DROP TABLE IF EXISTS `spesa_table`");
        _db.execSQL("DROP TABLE IF EXISTS `ricetta_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDispensaTable = new HashMap<String, TableInfo.Column>(1);
        _columnsDispensaTable.put("nome_prodotto", new TableInfo.Column("nome_prodotto", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDispensaTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDispensaTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDispensaTable = new TableInfo("dispensa_table", _columnsDispensaTable, _foreignKeysDispensaTable, _indicesDispensaTable);
        final TableInfo _existingDispensaTable = TableInfo.read(_db, "dispensa_table");
        if (! _infoDispensaTable.equals(_existingDispensaTable)) {
          return new RoomOpenHelper.ValidationResult(false, "dispensa_table(com.example.easycooking.DB.DispensaDBEntity).\n"
                  + " Expected:\n" + _infoDispensaTable + "\n"
                  + " Found:\n" + _existingDispensaTable);
        }
        final HashMap<String, TableInfo.Column> _columnsSpesaTable = new HashMap<String, TableInfo.Column>(1);
        _columnsSpesaTable.put("nome_prodotto", new TableInfo.Column("nome_prodotto", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSpesaTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSpesaTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSpesaTable = new TableInfo("spesa_table", _columnsSpesaTable, _foreignKeysSpesaTable, _indicesSpesaTable);
        final TableInfo _existingSpesaTable = TableInfo.read(_db, "spesa_table");
        if (! _infoSpesaTable.equals(_existingSpesaTable)) {
          return new RoomOpenHelper.ValidationResult(false, "spesa_table(com.example.easycooking.spesa.SpesaDBEntity).\n"
                  + " Expected:\n" + _infoSpesaTable + "\n"
                  + " Found:\n" + _existingSpesaTable);
        }
        final HashMap<String, TableInfo.Column> _columnsRicettaTable = new HashMap<String, TableInfo.Column>(8);
        _columnsRicettaTable.put("nome_ricetta", new TableInfo.Column("nome_ricetta", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRicettaTable.put("ingredienti_ricetta", new TableInfo.Column("ingredienti_ricetta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRicettaTable.put("tempocott_ricetta", new TableInfo.Column("tempocott_ricetta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRicettaTable.put("photo_ricetta", new TableInfo.Column("photo_ricetta", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRicettaTable.put("porzioni_ricetta", new TableInfo.Column("porzioni_ricetta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRicettaTable.put("tempoprep_ricetta", new TableInfo.Column("tempoprep_ricetta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRicettaTable.put("prep_ricetta", new TableInfo.Column("prep_ricetta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRicettaTable.put("tempotot_ricetta", new TableInfo.Column("tempotot_ricetta", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRicettaTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRicettaTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRicettaTable = new TableInfo("ricetta_table", _columnsRicettaTable, _foreignKeysRicettaTable, _indicesRicettaTable);
        final TableInfo _existingRicettaTable = TableInfo.read(_db, "ricetta_table");
        if (! _infoRicettaTable.equals(_existingRicettaTable)) {
          return new RoomOpenHelper.ValidationResult(false, "ricetta_table(com.example.easycooking.adapter.ricetta.RicettaDBEntity).\n"
                  + " Expected:\n" + _infoRicettaTable + "\n"
                  + " Found:\n" + _existingRicettaTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5ec5558777ff60a78ec027ae5a689c15", "585b2e75fab45e8515b00acee11a1b28");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "dispensa_table","spesa_table","ricetta_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `dispensa_table`");
      _db.execSQL("DELETE FROM `spesa_table`");
      _db.execSQL("DELETE FROM `ricetta_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DispensaDAO.class, DispensaDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(SpesaDAO.class, SpesaDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(RicettaDAO.class, RicettaDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public DispensaDAO DispensaDAO() {
    if (_dispensaDAO != null) {
      return _dispensaDAO;
    } else {
      synchronized(this) {
        if(_dispensaDAO == null) {
          _dispensaDAO = new DispensaDAO_Impl(this);
        }
        return _dispensaDAO;
      }
    }
  }

  @Override
  public SpesaDAO SpesaDAO() {
    if (_spesaDAO != null) {
      return _spesaDAO;
    } else {
      synchronized(this) {
        if(_spesaDAO == null) {
          _spesaDAO = new SpesaDAO_Impl(this);
        }
        return _spesaDAO;
      }
    }
  }

  @Override
  public RicettaDAO RicettaDAO() {
    if (_ricettaDAO != null) {
      return _ricettaDAO;
    } else {
      synchronized(this) {
        if(_ricettaDAO == null) {
          _ricettaDAO = new RicettaDAO_Impl(this);
        }
        return _ricettaDAO;
      }
    }
  }
}
