package com.example.easycooking.adapter.ricetta

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ricetta_table")
data class RicettaDBEntity (
     @PrimaryKey @ColumnInfo(name="nome_ricetta")val nome:String,
     @ColumnInfo(name="ingredienti_ricetta")val Ingredienti: String,
     @ColumnInfo(name="tempocott_ricetta")val cookTime: String,
     //@ColumnInfo(name="nome_ricetta")val descrizione: String? = null,

     @ColumnInfo(name="photo_ricetta")val image: String?,
     //@ColumnInfo(name="nome_ricetta")val intolleranze: List<String>? = null,


     @ColumnInfo(name="porzioni_ricetta")val porzioni: String,
     @ColumnInfo(name="tempoprep_ricetta")val prepTime: String,
     @ColumnInfo(name="prep_ricetta")val preparazione: String,
     //@ColumnInfo(name="nome_ricetta")val quantita: List<String>,
     //@ColumnInfo(name="nome_ricetta")val recipeCategory: String? = null,
     //@ColumnInfo(name="nome_ricetta")val recipeCuisine: String? = null,
     @ColumnInfo(name="tempotot_ricetta")val totalTime: String?,
     //@ColumnInfo(name="nome_ricetta")val unita: List<String>?
     //@ColumnInfo(name="nome_ricetta")val vegano: Boolean? = null
        //@ColumnInfo(name="quant_prodotto") val quantProdotto:Int?,
        // @ColumnInfo(name="unit_prodotto") val unitProdotto:String?
)