package com.example.easycooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.easycooking.view.RicetteCerca

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val senzaReg = findViewById<TextView>(R.id.senza_registrazione)
        senzaReg.setOnClickListener{
            val intent = Intent(this, RicetteCerca::class.java)
            //intent.putExtra(NOTE_ID, note.id)
            startActivity(intent)
        }
    }
}