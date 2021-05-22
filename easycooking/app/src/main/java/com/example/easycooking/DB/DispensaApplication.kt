package com.example.easycooking.DB

import android.app.Application
import com.example.easycooking.adapter.dispensa.DispensaRepository
import com.example.easycooking.spesa.SpesaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DispensaApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {ChoiceDatabase.getDatabase(this,applicationScope)}
    val repositoryDispensa by lazy {DispensaRepository(database.DispensaDAO())}
    val repositorySpesa by lazy { SpesaRepository(database.SpesaDAO()) }
}