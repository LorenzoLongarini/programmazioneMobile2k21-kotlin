package com.example.easycooking.memory.spesa

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * definizione della class Entity per la Spesa.
 * E' una classe che viene mappata ad una tabella di un database SQLite
 */

@Entity(tableName = "spesa_table")
data class SpesaDBEntity (

    @PrimaryKey @ColumnInfo(name="nome_prodotto")val nomeProdotto:String
)