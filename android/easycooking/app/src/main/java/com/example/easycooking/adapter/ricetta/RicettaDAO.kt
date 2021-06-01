package com.example.easycooking.adapter.ricetta

import androidx.room.*
import com.example.easycooking.DB.DispensaDBEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RicettaDAO {
    @Query("SELECT * FROM ricetta_table")
    fun getAll(): Flow<List<RicettaDBEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ricetta: RicettaDBEntity)

    @Delete()
    suspend fun delete(ricetta: RicettaDBEntity)

    @Query("DELETE FROM ricetta_table")
    suspend fun deleteAll()
}