package com.example.easycooking.adapter.offline

import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao
interface OfflineDAO {

    @Query("SELECT * FROM offline_table")
    fun getAll(): Flow<List<OfflineDBEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ricettaOf: OfflineDBEntity)

    @Delete()
    suspend fun delete(ricettaOf: OfflineDBEntity)

    @Query("DELETE FROM offline_table")
    suspend fun deleteAll()
}