package com.example.easycooking.DB

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DispensaDAO {
    @Query("SELECT * FROM dispensa_table")
    fun getAll(): Flow<List<DispensaDBEntity>>
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert( dispensa:DispensaDBEntity)
    @Query("DELETE FROM dispensa_table")
    fun delete(dispensa:DispensaDBEntity)
}