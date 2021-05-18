package com.example.easycooking.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dispensa")
data class DispensaDBEntity (

    @PrimaryKey val nomeProdotto:String,
    @ColumnInfo(name="quant_prodotto") val quantProdotto:Int?,
    @ColumnInfo(name="unit_prodotto") val unitProdotto:String?
        )