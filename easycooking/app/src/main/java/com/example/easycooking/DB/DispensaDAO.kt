package com.example.easycooking.DB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DispensaDAO {
    @Query("SELECT * FROM dispensa")
    fun getAll():List<DispensaDBEntity>
    @Insert
    fun insertAll(vararg dispensa:DispensaDBEntity)
    @Delete
    fun delete(dispensa:DispensaDBEntity)
}