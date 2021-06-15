package com.example.easycooking.memory.spesa

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/**
 * in questa classe andiamo ad inserire/eliminare il prodotto nella lista della spesa
 *
 */

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class SpesaRepository(private val spesaDao: SpesaDAO) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allprod: Flow<List<SpesaDBEntity>> = spesaDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    //andiamo a inserire il prodotto nella lista della spesa
    @WorkerThread
    suspend fun insert(spesa: SpesaDBEntity) {
        spesaDao.insert(spesa)
    }

    //andiamo ad eliminare il prodotto dalla lista della spesa
    @WorkerThread
    suspend fun delete(spesa: SpesaDBEntity) {
    spesaDao.delete(spesa)
    }
}