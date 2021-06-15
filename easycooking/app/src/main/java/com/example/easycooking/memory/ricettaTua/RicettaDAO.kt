package com.example.easycooking.memory.ricettaTua

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Classe DAO per le ricette
 */

@Dao
interface RicettaDAO {

    /**
     * attraverso questa query vengono visualizzate tutte le ricette salvate in locale
     */
    @Query("SELECT * FROM ricetta_table")
    fun getAll(): Flow<List<RicettaDBEntity>>

    /**
     * attraverso questa query viene inserita una ricetta nel database in locale
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ricetta: RicettaDBEntity)

    /**
     * attraverso questa query viene eliminata una ricetta nel database in locale
     */
    @Delete()
    suspend fun delete(ricetta: RicettaDBEntity)

    /**
     * attraverso questa query vengono eliminate tutte le ricette salvate nel database in locale
     */
    @Query("DELETE FROM ricetta_table")
    suspend fun deleteAll()
}