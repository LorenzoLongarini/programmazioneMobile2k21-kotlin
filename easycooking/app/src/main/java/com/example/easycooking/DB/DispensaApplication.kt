package com.example.easycooking.DB

import android.app.Application
import com.example.easycooking.adapter.dispensa.DispensaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DispensaApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {DispensaDatabase.getDatabase(this,applicationScope)}
    val repository by lazy {DispensaRepository(database.DispensaDAO())}
}