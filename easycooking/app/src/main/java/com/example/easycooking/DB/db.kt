package com.example.easycooking.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.easycooking.adapter.dispensa.Dispensa

@Database(entities = arrayOf(DispensaDBEntity::class), version = 1,exportSchema = false)
public abstract class DispensaDatabase : RoomDatabase() {
    abstract fun DispensaDAO(): DispensaDAO

    companion object {
        @Volatile
        private var INSTANCE: DispensaDatabase? = null
        fun getDatabase(context: Context): DispensaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DispensaDatabase::class.java,
                    "dispensa_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
                }
            }

        }
    }
