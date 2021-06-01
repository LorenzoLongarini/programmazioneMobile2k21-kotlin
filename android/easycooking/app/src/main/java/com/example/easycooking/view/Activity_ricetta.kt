package com.example.easycooking.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ShareCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import kotlinx.android.synthetic.main.cards.view.*

class Activity_ricetta : AppCompatActivity() {

    private lateinit var condividi: ImageButton

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
        val ingr:TextView=findViewById<TextView>(R.id.Ingredienti)
        val quant:TextView=findViewById<TextView>(R.id.Quantità)
        val unit:TextView=findViewById<TextView>(R.id.Unitàdimisura)
        val prep:TextView=findViewById<TextView>(R.id.procedimento_vista)
        val photo:ImageView=findViewById<ImageView>(R.id.photo)


        var arrayIntoll=intent.getStringArrayExtra("Intoll")
        var intoller=""
        if (arrayIntoll != null) {
            for (intol in arrayIntoll){
                intoller += intol
            }
        }else{
            intoller="nessuna intolleranza"
        }
        var arrayIngr=intent.getStringArrayExtra("Ingr")
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
        quant.text=quantit
        unit.text=unita
        prep.text=intent.getStringExtra("Preparaz")

        condividi = findViewById(R.id.button_share)

        condividi.setOnClickListener {


            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val shareSub = "Scarica EasyCooking"
            val shareBody = "Scarica la app EasyCooking per scoprire tante ricette come "+(titolo.text as String?)
            intent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
            intent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(intent, "Vieni a visitare la app EasyCooking"))


        }

    }


}