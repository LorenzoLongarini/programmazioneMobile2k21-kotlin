package com.example.easycooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.easycooking.activities.RicetteCerca

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.bottone_registrati)
        button.setOnClickListener{
            val intent = Intent(this, RicetteCerca::class.java)
            //intent.putExtra(NOTE_ID, note.id)
            //if login corretto
            startActivity(intent)
        }
    }
}