package com.example.easycooking.adapter.ricetta

import androidx.room.*
import com.example.easycooking.DB.DispensaDBEntity
import kotlinx.coroutines.flow.Flow

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
     * attraverso questa query vengono eliminate tutte le ricette salvatenel database in locale
     */
    @Query("DELETE FROM ricetta_table")
    suspend fun deleteAll()
}