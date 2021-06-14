package com.example.easycooking.memory.dispensa

import android.app.Application
import com.example.easycooking.memory.DB.ChoiceDatabase

import com.example.easycooking.memory.ricettaTua.RicettaRepository
import com.example.easycooking.memory.spesa.SpesaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DispensaApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ChoiceDatabase.getDatabase(this, applicationScope) }
    val repositoryDispensa by lazy {DispensaRepository(database.DispensaDAO())}
    val repositorySpesa by lazy { SpesaRepository(database.SpesaDAO()) }
    val repositoryRicetta by lazy { RicettaRepository(database.RicettaDAO()) }
}