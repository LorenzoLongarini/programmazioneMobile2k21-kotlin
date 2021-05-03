package com.example.easycooking.database.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

// [START rtdb_ricetta_class]
@IgnoreExtraProperties
data class Ricetta(var id: String? = null, var nome: String? = null, var image: String? = null,
                   var descrizione: String? = null, var prepTime: String? = null, var cookTime: String? = null,
                   var totalTime: String? = null, var keywords: List<String>? = null, var recipeCategory: String? = null,
                   var recipeCuisine: String? = null, var intolleranze: List<String>? = null, var vegano: Boolean? = null,
                   var porzioni: String? = null, var Ingredienti: List<Ingrediente>? = null,
                   var preparazione: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
    // [START ricetta_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
                "id" to id,
                "nome" to nome,
                "image" to image,
                "descrizione" to descrizione,
                "prepTime" to prepTime,
                "cookTime" to cookTime,
                "totalTime" to totalTime,
                "keywords" to keywords,
                "recipeCategory" to recipeCategory,
                "recipeCuisine" to recipeCuisine,
                "intolleranze" to intolleranze,
                "vegano" to vegano,
                "porzioni" to porzioni,
                "Ingredienti" to Ingredienti,
                "preparazione" to preparazione
        )
    }
}
