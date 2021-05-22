package com.example.easycooking.spesa

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(SpesaDBEntity::class), version = 1,exportSchema = false)
public abstract class SpesaDatabase : RoomDatabase() {
    abstract fun SpesaDAO(): SpesaDAO
    companion object {
        @Volatile
        private var INSTANCE: SpesaDatabase? = null
        fun getDatabase(context: Context,scope: CoroutineScope): SpesaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpesaDatabase::class.java,
                    "spesa_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(SpesaDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
    }

    private class SpesaDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback(){
        /**
         * Override the onCreate method to populate the database.
         */
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // If you want to keep the data through app restarts,
            // comment out the following line.
            INSTANCE?.let { database ->
                scope.launch{
                    var spesaDao = database.SpesaDAO()

                    // Start the app with a clean database every time.
                    // Not needed if you only populate on creation.
                    spesaDao.deleteAll()



                }
            }
        }}}