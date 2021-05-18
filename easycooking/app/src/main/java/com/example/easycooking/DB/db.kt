package com.example.easycooking.DB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DispensaDBEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DispensaDAO(): DispensaDAO
}