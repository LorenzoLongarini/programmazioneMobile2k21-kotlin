package com.example.easycooking.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.easycooking.adapter.dispensa.Dispensa
import com.example.easycooking.adapter.ricetta.RicettaDAO
import com.example.easycooking.adapter.ricetta.RicettaDBEntity
import com.example.easycooking.spesa.SpesaDAO
import com.example.easycooking.spesa.SpesaDBEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(DispensaDBEntity::class, SpesaDBEntity::class,RicettaDBEntity::class), version = 5,exportSchema = false)
public abstract class ChoiceDatabase : RoomDatabase() {
    companion object {

        @Volatile
        private var INSTANCE: ChoiceDatabase? = null
        fun getDatabase(context: Context,scope: CoroutineScope): ChoiceDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChoiceDatabase::class.java,
                    "choice_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(ChoiceDatabaseCallback(scope))
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

    abstract fun DispensaDAO(): DispensaDAO
    abstract fun SpesaDAO(): SpesaDAO
    abstract fun RicettaDAO(): RicettaDAO

    private class ChoiceDatabaseCallback(
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
                    var dispensaDao = database.DispensaDAO()
                    var spesaDao = database.SpesaDAO()
                    var ricettaDao = database.RicettaDAO()

            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            dispensaDao.deleteAll()
            spesaDao.deleteAll()
            ricettaDao.deleteAll()

            /*var dispensa= DispensaDBEntity("Hello",10,"grammi")
            dispensaDao.insert(dispensa)
            dispensa= DispensaDBEntity("World!",20,"Litri")
            dispensaDao.insert(dispensa)*/

    }
}
        }}



}