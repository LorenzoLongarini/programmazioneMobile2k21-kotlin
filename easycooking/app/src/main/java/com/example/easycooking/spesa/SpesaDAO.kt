package com.example.easycooking.spesa

import androidx.room.*
import com.example.easycooking.spesa.SpesaDBEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpesaDAO {
    @Query("SELECT * FROM spesa_table")
    fun getAll(): Flow<List<SpesaDBEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert( itemSpesa: SpesaDBEntity)
    @Query("DELETE FROM spesa_table")
    suspend fun deleteAll()

}