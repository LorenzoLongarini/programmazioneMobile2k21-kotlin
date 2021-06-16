package com.example.easycooking.memory.DB

import android.app.Application
import com.example.easycooking.memory.dispensa.DispensaRepository

import com.example.easycooking.memory.ricettaTua.RicettaRepository
import com.example.easycooking.memory.spesa.SpesaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * In questa classe vengono definite tutte le repository
 */

class DispensaApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ChoiceDatabase.getDatabase(this, applicationScope) }
    val repositoryDispensa by lazy { DispensaRepository(database.DispensaDAO()) }
    val repositorySpesa by lazy { SpesaRepository(database.SpesaDAO()) }
    val repositoryRicetta by lazy { RicettaRepository(database.RicettaDAO()) }
}