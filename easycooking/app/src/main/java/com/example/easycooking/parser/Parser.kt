package com.example.easycooking.parser

import android.util.JsonReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class Parser {

    val ricetteURL="https://gino-49a3d-default-rtdb.firebaseio.com/.json?auth=hjzX17Km02W8odPD3Tw2nBSKaR3oRFd5NzmHzZdr"

    @Throws(IOException::class)
    fun readJsonStream(filein: InputStream?): List<Ricetta?>? {
        val reader = JsonReader(InputStreamReader(filein, "UTF-8"))
        return try {
            readRicetteArray(reader)
        } finally {
            reader.close()
        }
    }

    @Throws(IOException::class)
    fun readRicetteArray(reader: JsonReader): List<Ricetta?>? {
        val ricette: MutableList<Ricetta?> = ArrayList<Ricetta?>()
        reader.beginArray()
        while (reader.hasNext()) {
            ricette.add(readRicetta(reader))
        }
        reader.endArray()
        return ricette
    }

    @Throws(IOException::class)
    fun readRicetta(reader: JsonReader):Ricetta? {
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
        var Ingredienti: List<Ingrediente>? = null
        var preparazione: String? = null

        reader.beginObject()
        while (reader.hasNext()) {
            var name: String = reader.nextName()
            if (name.equals("nome")) {
                nome = reader.nextString()
            } else if (name.equals("image")) {
                image = reader.nextString()
            } else if (name.equals("descrizione")) {
                descrizione = reader.nextString()
            } else if (name.equals("prepTime")) {
                prepTime = reader.nextString()
            } else if (name.equals("cookTime")) {
                cookTime = reader.nextString()
            } else if (name.equals("totalTime")) {
                totalTime = reader.nextString()
            } else if (name.equals("keywords")) { //presta bene attenzione a questa variabile
                keywords = readStringArray(reader)
            } else if (name.equals("recipeCategory")) {
                recipeCategory = reader.nextString()
            } else if (name.equals("recipeCuisine")) {
                recipeCuisine = reader.nextString()
            } else if (name.equals("intolleranze")) {
                intolleranze = readStringArray(reader)
            } else if (name.equals("vegano")) {
                vegano = reader.nextBoolean()
            } else if (name.equals("porzioni")) {
                porzioni = reader.nextInt()
            } else if (name.equals("Ingredienti")) {
                Ingredienti = readIngredientiArray(reader) //fai super attenzione
            } else if (name.equals("preparazione")) {
                preparazione = reader.nextString()
            }
        }
            reader.endObject()
            return Ricetta(nome,image,descrizione,prepTime,cookTime,totalTime,keywords,recipeCategory,recipeCuisine,intolleranze,vegano,porzioni,Ingredienti,preparazione)

    }

    @Throws(IOException::class)
    fun readStringArray(reader: JsonReader):List<String>{
        lateinit var strings:ArrayList<String>

        reader.beginArray()
        while (reader.hasNext()) {
            strings.add(reader.nextString())
        }
        reader.endArray()
        return strings
    }

    @Throws(IOException::class)
    fun readIngrediente(reader: JsonReader):Ingrediente  {
        var nomeIngr: String? = null
        var quantità: String? = null
        var unitaMisura: String? = null


        reader.beginObject()
        while (reader.hasNext()) {
            var name:String = reader.nextName ()
            if (name.equals("nomeIngr")) {
                nomeIngr = reader.nextString()
            } else if (name.equals("quantità")) {
                quantità = reader.nextString()
            } else if (name.equals("unitaMisura")) {
                unitaMisura = reader.nextString()
            }
        }
        reader.endObject();
        return Ingrediente(nomeIngr,quantità,unitaMisura)
    }

    @Throws(IOException::class)
    fun readIngredientiArray(reader: JsonReader):List<Ingrediente>   {
        lateinit var ingredienti:ArrayList<Ingrediente>

        reader.beginArray();
        while (reader.hasNext()) {
            ingredienti.add(readIngrediente(reader));
        }
        reader.endArray();
        return ingredienti;
    }
}