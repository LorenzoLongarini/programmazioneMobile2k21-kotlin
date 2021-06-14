package com.example.easycooking.memory.spesa

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SpesaDAO {
    @Query("SELECT * FROM spesa_table")
    fun getAll(): Flow<List<SpesaDBEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert( itemSpesa: SpesaDBEntity)
    @Delete()
    suspend fun delete(spesa: SpesaDBEntity)
    @Query("DELETE FROM spesa_table")
    suspend fun deleteAll()

}