package com.example.easycooking.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.easycooking.R

class ListaSpesa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_lista_spesa)
        setContentView(R.layout.activity_listaspesa)
    }
    fun dispensa(v: View){
        val intent = Intent(this, Dispensa::class.java)
        startActivity(intent)
    }
    fun ricetteCerca(v: View){
        val intent = Intent(this, RicetteCerca::class.java)
        startActivity(intent)
    }
    fun ricetteTue(v: View) {
        val intent = Intent(this, RicetteTue::class.java)
        startActivity(intent)
    }
}