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
import kotlinx.android.synthetic.main.cards.view.*

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
        val photo:ImageView=findViewById<ImageView>(R.id.photo)


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
        var veggy=intent.getBooleanExtra("Veg",false)
        var vegano="No"
        if (veggy){
            vegano="Si"
        }

        val storage = Firebase.storage
        var image=intent.getStringExtra("image")
        val n_image = "images/".plus(image)
        val imagereference = storage.reference.child(n_image)
        imagereference.downloadUrl.addOnSuccessListener { uri ->
            Glide.with(this)
                .load(uri)
                //.fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL) //ALL or NONE as your requirement
                .into(photo)
        }.addOnFailureListener { // Handle any errors
            Glide.with(this)
                .load(R.drawable.coltforc)
                //.fitCenter()
                .into(photo)
        }


        titolo.text=intent.getStringExtra("Titolo")
        prepTime.text=intent.getStringExtra("Prep")
        cookTime.text=intent.getStringExtra("Cott")
        totTime.text=intent.getStringExtra("Tot")
        cat.text=intent.getStringExtra("Cat")
        orig.text=intent.getStringExtra("Orig")
        intoll.text=intoller
        veg.text=vegano
        ingr.text=ingred
        prep.text=intent.getStringExtra("Preparaz")

    }
}