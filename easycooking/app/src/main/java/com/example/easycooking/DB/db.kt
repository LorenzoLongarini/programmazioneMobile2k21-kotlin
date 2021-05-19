package com.example.easycooking.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.easycooking.adapter.dispensa.Dispensa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(DispensaDBEntity::class), version = 1,exportSchema = false)
public abstract class DispensaDatabase : RoomDatabase() {
    abstract fun DispensaDAO(): DispensaDAO





    companion object {
        @Volatile
        private var INSTANCE: DispensaDatabase? = null
        fun getDatabase(context: Context,scope: CoroutineScope): DispensaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DispensaDatabase::class.java,
                    "dispensa_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(DispensaDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
                }
            }
        private class DispensaDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.DispensaDAO())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(dispensaDao: DispensaDAO) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            dispensaDao.deleteAll()

            var dispensa= DispensaDBEntity("Hello",10,"grammi")
            dispensaDao.insert(dispensa)
            dispensa= DispensaDBEntity("World!",20,"Litri")
            dispensaDao.insert(dispensa)
        }
    }
}