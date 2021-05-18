package com.example.easycooking.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DispensaDBEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DispensaDAO(): DispensaDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "dispensa"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}