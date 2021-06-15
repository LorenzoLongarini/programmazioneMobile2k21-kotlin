package com.example.easycooking.memory.spesa

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Classe DAO per la Spesa
 */

@Dao
interface SpesaDAO {

    /**
     * attraverso questa query vengono visualizzati tutti i prodotti presenti nella lista della spesa
     */
    @Query("SELECT * FROM spesa_table")
    fun getAll(): Flow<List<SpesaDBEntity>>

    /**
     * attraverso questa query viene inserito un prodotto all'interno della lista della spesa
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert( itemSpesa: SpesaDBEntity)

    /**
     * attraverso questa query viene eliminato un prodotto all'interno della lista della spesa
     */
    @Delete()
    suspend fun delete(spesa: SpesaDBEntity)

    /**
     * attraverso questa query vengono eliminati tutti i prodotti all'interno della lista della spesa
     */
    @Query("DELETE FROM spesa_table")
    suspend fun deleteAll()

}