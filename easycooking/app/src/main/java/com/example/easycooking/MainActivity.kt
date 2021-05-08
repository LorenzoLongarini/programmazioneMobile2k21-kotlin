package com.example.easycooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.easycooking.view.RicetteCerca
import android.view.View
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun senzaReg(v: View){
        val intent = Intent(this, RicetteCerca::class.java)
        startActivity(intent)
    }
}