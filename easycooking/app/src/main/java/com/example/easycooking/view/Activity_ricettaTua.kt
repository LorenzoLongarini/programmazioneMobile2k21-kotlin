package com.example.easycooking.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R

import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class Activity_ricettaTua : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ricetta_tua)

        val titolo: TextView =findViewById<TextView>(R.id.immagine_ricetta_vista)
        val prepTime: TextView =findViewById<TextView>(R.id.tempo_preparazione)
        val cookTime: TextView =findViewById<TextView>(R.id.tempo_cottura)
        val totTime: TextView =findViewById<TextView>(R.id.tempo_totale)
        val ingr: TextView =findViewById<TextView>(R.id.Ingredienti)
        val prep: TextView =findViewById<TextView>(R.id.procedimento_vista)
        val photona: ImageView=findViewById<ImageView>(R.id.photona)

        var aiuto=intent.getIntExtra("aiuto",0)
        var foto=intent.getStringExtra("foto")

        titolo.text=intent.getStringExtra("Titolo")
        prepTime.text=intent.getStringExtra("Prep")
        cookTime.text=intent.getStringExtra("Cott")
        totTime.text=intent.getStringExtra("Tot")
        ingr.text=intent.getStringExtra("Ingr")
        prep.text=intent.getStringExtra("Preparaz")

        if(aiuto==1){
            val uri: Uri = Uri.parse(foto)
            Glide.with(this)
                .load(uri)
                .into(photona)}
        else if (aiuto==0){
            photona.setImageBitmap(foto?.let { base64ToBitmap(it) })
        }
    }
}
private fun base64ToBitmap(b64: String): Bitmap {
    val imageAsBytes = Base64.decode(b64.toByteArray(), Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
}