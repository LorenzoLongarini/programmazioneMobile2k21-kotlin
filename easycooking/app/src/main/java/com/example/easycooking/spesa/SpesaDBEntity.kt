package com.example.easycooking.spesa

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spesa_table")
data class SpesaDBEntity (

    @PrimaryKey @ColumnInfo(name="nome_prodotto")val nomeProdotto:String
)