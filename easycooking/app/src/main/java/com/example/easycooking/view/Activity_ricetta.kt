package com.example.easycooking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.easycooking.R

class Activity_ricetta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_ricetta)

        val titolo:TextView=findViewById<TextView>(R.id.immagine_ricetta_vista)
        val prepTime:TextView=findViewById<TextView>(R.id.tempo_preparazione)
        val cookTime:TextView=findViewById<TextView>(R.id.tempo_cottura)
        val totTime:TextView=findViewById<TextView>(R.id.tempo_totale)
        val cat:TextView=findViewById<TextView>(R.id.categoria)
        val orig:TextView=findViewById<TextView>(R.id.origine)
        val intoll:TextView=findViewById<TextView>(R.id.intolleranze)
        val veg:TextView=findViewById<TextView>(R.id.vegano)
        val ingr:TextView=findViewById<TextView>(R.id.lista_ingrdienti_vista)
        val prep:TextView=findViewById<TextView>(R.id.procedimento_vista)


        var arrayIntoll=intent.getStringArrayExtra("Intoll")
        var intoller=""
        if (arrayIntoll != null) {
            for (intol in arrayIntoll){
                intoller += intol
            }
        }
        var arrayIngr=intent.getStringArrayExtra("Ingr")
        var ingred=""
        if (arrayIngr != null) {
            for (ing in arrayIngr){
                ingred=ingred+ing+"\n"
            }
        }


        titolo.text=intent.getStringExtra("Titolo")
        prepTime.text=intent.getStringExtra("Prep")
        cookTime.text=intent.getStringExtra("Cott")
        totTime.text=intent.getStringExtra("Tot")
        cat.text=intent.getStringExtra("Cat")
        orig.text=intent.getStringExtra("Orig")
        intoll.text=intoller
        //veg.text=intent.getBooleanExtra("Veg")
        ingr.text=ingred
        prep.text=intent.getStringExtra("Preparaz")

    }
}