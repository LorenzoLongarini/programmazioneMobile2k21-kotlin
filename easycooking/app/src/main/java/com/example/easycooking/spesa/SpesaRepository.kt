package com.example.easycooking.spesa

import androidx.annotation.WorkerThread
import com.example.easycooking.DB.DispensaDAO
import com.example.easycooking.DB.DispensaDBEntity
import com.example.easycooking.DB.SpesaDBEntity
import kotlinx.coroutines.flow.Flow

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
    @WorkerThread
    suspend fun insert(spesa: SpesaDBEntity) {
        spesaDao.insert(spesa)
    }
}