package com.example.easycooking.adapter.ricetta

import androidx.annotation.WorkerThread
import com.example.easycooking.DB.DispensaDAO
import com.example.easycooking.DB.DispensaDBEntity
import kotlinx.coroutines.flow.Flow

class RicettaRepository (private val ricettaDao: RicettaDAO) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allprod: Flow<List<RicettaDBEntity>> = ricettaDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    //andiamo a inserire la ricetta
    suspend fun insert(ricetta: RicettaDBEntity) {
        ricettaDao.insert(ricetta)
    }
    @WorkerThread
    //andiamo a eliminare la ricetta
    suspend fun delete(ricetta: RicettaDBEntity){
        ricettaDao.delete(ricetta)
    }
}