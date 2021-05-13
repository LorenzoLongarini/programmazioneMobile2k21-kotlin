package com.example.easycooking.adapter.ricetta

data class Ricetta (

        var Ingredienti:List<String>?=null,
        var cookTime: String? = null,
        var descrizione: String? = null,
        var id:Int?=null,
        var image: String? = null,
        var intolleranze: List<String>? = null,
        var keywords: List<String>? = null,
        var nome: String? = null,
        var porzioni: Int? = null,
        var prepTime: String? = null,
        var preparazione: String? = null,
        var quantita:List<String>?=null,
        var recipeCategory: String? = null,
        var recipeCuisine: String? = null,
        var totalTime: String? = null,
        var unita:List<String>?=null,
        var vegano: Boolean?= null
)

