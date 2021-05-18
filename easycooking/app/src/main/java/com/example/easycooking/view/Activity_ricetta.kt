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

        titolo.text=intent.getStringExtra("Titolo")

    }
}