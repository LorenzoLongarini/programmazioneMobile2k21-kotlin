package com.example.easycooking.spesa

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SpesaDatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, SpesaCont.DB_NAME, null, SpesaCont.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE " + SpesaCont.SpesaEntry.TABLE.toString() + " ( " +
                SpesaCont.SpesaEntry._ID.toString() + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SpesaCont.SpesaEntry.COL_TASK_TITLE.toString() + " TEXT NOT NULL);"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + SpesaCont.SpesaEntry.TABLE)
        onCreate(db)
    }
}
