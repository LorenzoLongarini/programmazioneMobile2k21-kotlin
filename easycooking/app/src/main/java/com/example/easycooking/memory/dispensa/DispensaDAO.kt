package com.example.easycooking.memory.dispensa

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Classe DAO per la dispensa
 */
@Dao
interface DispensaDAO {

    /**
     * attraverso questa query vengono visualizzate tutte i prodotti presenti in dispensa
     */
    @Query("SELECT * FROM dispensa_table")
    fun getAll(): Flow<List<DispensaDBEntity>>

    /**
     * attraverso questa query viene inserito un prodotto in dispensa
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert( dispensa: DispensaDBEntity)

    /**
     * attraverso questa query viene eliminato un prodotto in dispensa
     */
    @Delete()
    suspend fun delete(dispensa: DispensaDBEntity)

    /**
     * attraverso questa query vengono eliminati tutti prodotti presenti in dispensa
     */
    @Query("DELETE FROM dispensa_table")
    suspend fun deleteAll()

}