package com.example.easycooking.memory.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.easycooking.memory.dispensa.DispensaDAO
import com.example.easycooking.memory.dispensa.DispensaDBEntity
import com.example.easycooking.memory.ricettaTua.RicettaDAO
import com.example.easycooking.memory.ricettaTua.RicettaDBEntity
import com.example.easycooking.memory.spesa.SpesaDAO
import com.example.easycooking.memory.spesa.SpesaDBEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * questa classe astratta viene utilizzata per definire le room che abbiamo utilizzato nella nostra applicazione
 */

@Database(entities = arrayOf(DispensaDBEntity::class, SpesaDBEntity::class, RicettaDBEntity::class), version = 9,exportSchema = false)
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
                //aggiorna la lista con i dati nel database
                instance
            }
        }
    }

    //definizione delle room utilizzate
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
                    //inizializzazione dei database
                    var dispensaDao = database.DispensaDAO()
                    var spesaDao = database.SpesaDAO()
                    var ricettaDao = database.RicettaDAO()

            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            dispensaDao.deleteAll()
            spesaDao.deleteAll()
            ricettaDao.deleteAll()
                }
            }
        }
    }



}