package com.example.easycooking.spesa

import android.app.Application

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class SpesaApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { SpesaDatabase.getDatabase(this,applicationScope)}
    val repository by lazy {SpesaRepository(database.SpesaDAO())}
}