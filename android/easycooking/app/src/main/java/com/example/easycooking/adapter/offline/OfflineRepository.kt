package com.example.easycooking.adapter.offline

import androidx.annotation.WorkerThread


import kotlinx.coroutines.flow.Flow

class OfflineRepository (private val offDao: OfflineDAO){


    val offprod: Flow<List<OfflineDBEntity>> = offDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(ricetta: OfflineDBEntity) {
        offDao.insert(ricetta)
    }
    @WorkerThread
    suspend fun delete(ricetta: OfflineDBEntity){
        offDao.delete(ricetta)
    }
}