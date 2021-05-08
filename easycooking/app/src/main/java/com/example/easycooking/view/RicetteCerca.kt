package com.example.easycooking.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.easycooking.R

class RicetteCerca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ricettecerca)
    }

    fun dispensa(v: View){
        val intent = Intent(this, Dispensa::class.java)
        startActivity(intent)
    }
    fun listaSpesa(v: View){
        val intent = Intent(this, ListaSpesa::class.java)
        startActivity(intent)
    }
    fun ricetteTue(v: View) {
        val intent = Intent(this, RicetteTue::class.java)
        startActivity(intent)
    }
}