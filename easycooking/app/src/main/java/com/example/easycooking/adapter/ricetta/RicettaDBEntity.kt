package com.example.easycooking.adapter.ricetta

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ricetta_table")
data class RicettaDBEntity (
     @PrimaryKey @ColumnInfo(name="nome_ricetta")val nome:String,
     @ColumnInfo(name="nome_ricetta")val Ingredienti: List<String>? = null,
     @ColumnInfo(name="nome_ricetta")val cookTime: String? = null,
     @ColumnInfo(name="nome_ricetta")val descrizione: String? = null,
     @ColumnInfo(name="nome_ricetta")val id: Int? = null,
     @ColumnInfo(name="nome_ricetta")val image: String? = null,
     @ColumnInfo(name="nome_ricetta")val intolleranze: List<String>? = null,
     @ColumnInfo(name="nome_ricetta")val keywords: List<String>? = null,

     @ColumnInfo(name="nome_ricetta")val porzioni: String? = null,
     @ColumnInfo(name="nome_ricetta")val prepTime: String? = null,
     @ColumnInfo(name="nome_ricetta")val preparazione: String? = null,
     @ColumnInfo(name="nome_ricetta")val quantita: List<String>? = null,
     @ColumnInfo(name="nome_ricetta")val recipeCategory: String? = null,
     @ColumnInfo(name="nome_ricetta")val recipeCuisine: String? = null,
     @ColumnInfo(name="nome_ricetta")val totalTime: String? = null,
     @ColumnInfo(name="nome_ricetta")val unita: List<String>? = null,
     @ColumnInfo(name="nome_ricetta")val vegano: Boolean? = null
        //@ColumnInfo(name="quant_prodotto") val quantProdotto:Int?,
        // @ColumnInfo(name="unit_prodotto") val unitProdotto:String?
)