package com.example.easycooking.memory.dispensa

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * definizione della class Entity per la dispensa.
 * E' una classe che viene mappata ad una tabella di un database SQLite
 */

@Entity(tableName = "dispensa_table")
data class DispensaDBEntity (

    @PrimaryKey @ColumnInfo(name="nome_prodotto")val nomeProdotto:String,
        )