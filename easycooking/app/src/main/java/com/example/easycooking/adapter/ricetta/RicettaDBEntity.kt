package com.example.easycooking.adapter.ricetta

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * definizione della class Entity per la ricetta.
 * E' una classe che viene mappata ad una tabella di un database SQLite
 */

@Entity(tableName = "ricetta_table")
data class RicettaDBEntity (
     @PrimaryKey @ColumnInfo(name="nome_ricetta")val nome:String,
     @ColumnInfo(name="ingredienti_ricetta")val Ingredienti: String,
     @ColumnInfo(name="tempocott_ricetta")val cookTime: String,
     @ColumnInfo(name="photo_ricetta")val image: String?,
     @ColumnInfo(name="porzioni_ricetta")val porzioni: String,
     @ColumnInfo(name="tempoprep_ricetta")val prepTime: String,
     @ColumnInfo(name="prep_ricetta")val preparazione: String,
     @ColumnInfo(name="tempotot_ricetta")val totalTime: String?,
     @ColumnInfo(name="aiuto")val aiuto:Int,
)