package com.example.easycooking.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.easycooking.R

class RicetteCerca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ricettetue = findViewById<ImageView>(R.id.imageView11)
        ricettetue.setOnClickListener{
            val intent = Intent(this, RicetteTue::class.java)
            //intent.putExtra(NOTE_ID, note.id)
            startActivity(intent)
    }
        val dispensa = findViewById<ImageView>(R.id.imageView9)
        dispensa.setOnClickListener{
            val intent = Intent(this, Dispensa::class.java)
            //intent.putExtra(NOTE_ID, note.id)
            startActivity(intent)
        }
        val listaspesa = findViewById<ImageView>(R.id.imageView12)
        listaspesa.setOnClickListener{
            val intent = Intent(this, ListaSpesa::class.java)
            //intent.putExtra(NOTE_ID, note.id)
            startActivity(intent)
        }
}
}