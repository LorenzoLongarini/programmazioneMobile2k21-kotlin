package com.example.easycooking.adapter.offline

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "offline_table")
data class OfflineDBEntity(


        @PrimaryKey @ColumnInfo(name = "nome_ricetta") var nome: String,
        @ColumnInfo(name = "ingredienti_ricetta") var Ingredienti: String,
        @ColumnInfo(name = "tempocott_ricetta") val cookTime: String,
        @ColumnInfo(name = "descrizione_ricetta") val descrizione: String,
        @ColumnInfo(name = "photo_ricetta") val image: String?,
        /* @ColumnInfo(name="nome_ricetta")val intolleranze: List<String>,*/
        @ColumnInfo(name = "porzioni_ricetta") val porzioni: String,
        @ColumnInfo(name = "tempoprep_ricetta") val prepTime: String,
        @ColumnInfo(name = "prep_ricetta") val preparazione: String,
        // @ColumnInfo(name="nome_ricetta")val quantita: List<String>,
        @ColumnInfo(name = "category_ricetta") val recipeCategory: String? = null,
        @ColumnInfo(name = "cusine_ricetta") val recipeCuisine: String? = null
)
