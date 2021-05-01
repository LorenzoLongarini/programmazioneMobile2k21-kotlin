package com.example.easycooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easycooking.activities.RicetteCerca

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun viewNoteDetail() {
            val intent = Intent(this, RicetteCerca::class.java)
            //intent.putExtra(NOTE_ID, note.id)
            startActivity(intent)
        }
    }
}