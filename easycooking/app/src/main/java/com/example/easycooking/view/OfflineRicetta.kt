package com.example.easycooking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class OfflineRicetta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline_ricetta)

        val titolo: TextView =findViewById<TextView>(R.id.immagine_ricetta_vista1)
        val prepTime: TextView =findViewById<TextView>(R.id.tempo_preparazione1)
        val cookTime: TextView =findViewById<TextView>(R.id.tempo_cottura1)
        val totTime: TextView =findViewById<TextView>(R.id.tempo_totale1)
        val cat: TextView =findViewById<TextView>(R.id.categoria1)
        val orig: TextView =findViewById<TextView>(R.id.origine1)
        val intoll: TextView =findViewById<TextView>(R.id.intolleranze1)
        val veg: TextView =findViewById<TextView>(R.id.vegano1)
        val ingr: TextView =findViewById<TextView>(R.id.Ingredienti1)
        val quant: TextView =findViewById<TextView>(R.id.Quantità1)
        val unit: TextView =findViewById<TextView>(R.id.Unitàdimisura1)
        val prep: TextView =findViewById<TextView>(R.id.procedimento_vista1)
        val photo: ImageView =findViewById<ImageView>(R.id.photo1)
        var arrayIntoll=intent.getStringArrayExtra("Intoll")
        var intoller=""
        if (arrayIntoll != null) {
            for (intol in arrayIntoll){
                intoller += intol
            }
        }else{
            intoller="nessuna intolleranza"
        }
        /*var arrayIngr=intent.getStringArrayExtra("Ingr")
        var ingred=""
        if (arrayIngr != null) {
            for (ing in arrayIngr){
                ingred=ingred+ing+"\n"
            }
        }
        var arrayQuant=intent.getStringArrayExtra("Quant")
        var quantit=""
        if (arrayQuant != null) {
            for (ing in arrayQuant){
                quantit=quantit+ing+"\n"
            }
        }else{
            quantit="null"
        }
        var arrayUnit=intent.getStringArrayExtra("Unit")
        var unita=""
        if (arrayUnit != null) {
            for (ing in arrayUnit){
                unita=unita+ing+"\n"
            }
        }
        var veggy=intent.getBooleanExtra("Veg",false)
        var vegano="No"
        if (veggy){
            vegano="Si"
        }*/


        titolo.text=intent.getStringExtra("Titolo")
        prepTime.text=intent.getStringExtra("Prep")
        cookTime.text=intent.getStringExtra("Cott")
        totTime.text=intent.getStringExtra("Tot")
        cat.text=intent.getStringExtra("Cat")
        orig.text=intent.getStringExtra("Orig")
        intoll.text=intoller
        //veg.text=vegano
        //ingr.text=ingred
        //quant.text=quantit
        //unit.text=unita
        prep.text=intent.getStringExtra("Preparaz")
    }
}