package com.example.easycooking.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.easycooking.R

class Dispensa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispensa)
    }
    fun ricetteCerca(v: View){
        val intent = Intent(this, RicetteCerca::class.java)
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