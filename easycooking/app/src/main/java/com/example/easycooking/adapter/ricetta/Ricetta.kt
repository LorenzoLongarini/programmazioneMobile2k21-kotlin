package com.example.easycooking.adapter.ricetta

class Ricetta {


        var nome: String? = null
        var image: String? = null
        var descrizione: String? = null
        var prepTime: String? = null
        var cookTime: String? = null
        var totalTime: String? = null
        var keywords: List<String>? = null
        var recipeCategory: String? = null
        var recipeCuisine: String? = null
        var intolleranze: List<String>? = null
        var vegano: Boolean = false
        var porzioni: Int = 0
        var preparazione: String? = null

        constructor(nome: String?, image: String?, descrizione: String?, prepTime: String?, cookTime: String?, totalTime: String?, keywords: List<String>?, recipeCategory: String?, recipeCuisine: String?, intolleranze: List<String>?, vegano: Boolean, porzioni: Int, Ingredienti: List<Ingrediente>?, preparazione: String?){
                this.nome=nome
                this.image=image
                this.descrizione=descrizione
                this.prepTime=prepTime
                this.cookTime=cookTime
                this.totalTime=totalTime
                this.keywords=keywords
                this.recipeCategory=recipeCategory
                this.recipeCuisine=recipeCuisine
                this.intolleranze=intolleranze
                this.vegano=vegano
                this.porzioni=porzioni
                this.preparazione=preparazione
        }

        }
