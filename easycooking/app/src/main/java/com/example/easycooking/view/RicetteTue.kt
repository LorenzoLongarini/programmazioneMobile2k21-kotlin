package com.example.easycooking.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.easycooking.R

class RicetteTue : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ricettetue)
    }
    fun dispensa(v: View){
        val intent = Intent(this, Dispensa::class.java)
        startActivity(intent)
    }
    fun listaSpesa(v: View){
        val intent = Intent(this, ListaSpesa::class.java)
        startActivity(intent)
    }
    fun ricetteCerca(v: View) {
        val intent = Intent(this, RicetteCerca::class.java)
        startActivity(intent)
    }
}