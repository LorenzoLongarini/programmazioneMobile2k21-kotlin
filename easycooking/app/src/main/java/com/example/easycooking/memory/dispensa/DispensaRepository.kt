package com.example.easycooking.memory.dispensa

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/**
 * in questa classe andiamo ad inserire/eliminare il prodotto in dispensa
 *
 */

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class DispensaRepository(private val dispensaDao: DispensaDAO) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allprod: Flow<List<DispensaDBEntity>> = dispensaDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    //andiamo a inserire il prodotto in dispensa
    @WorkerThread
    suspend fun insert(dispensa: DispensaDBEntity) {
        dispensaDao.insert(dispensa)
    }

    //andiamo ad eliminare il prodotto dalla dispensa
    @WorkerThread
    suspend fun delete(dispensa: DispensaDBEntity){
        dispensaDao.delete(dispensa)
    }
}