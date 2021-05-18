package com.example.easycooking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.easycooking.DB.AppDatabase
import com.example.easycooking.DB.DispensaDBEntity
import com.example.easycooking.R

class Activity_inserisci_dispensa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserisci_in_dispensa)

        val nom:EditText=findViewById<EditText>(R.id.nome_prodotto_inserimento)
        val quant:EditText=findViewById<EditText>(R.id.quantita_prodotto_inserimento)
        val un:EditText=findViewById<EditText>(R.id.unita_inserimento)
        val bt:Button=findViewById<Button>(R.id.bottone_aggiungi_inserimento)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "dispensa"
        ).build()



        bt.setOnClickListener {
            val da_aggiungere:DispensaDBEntity= DispensaDBEntity(nom.text.toString(),quant.text.toString().toInt(),un.text.toString())
            val dbDAO=db?.DispensaDAO()
            dbDAO.insertAll(da_aggiungere)
            this.finish()
        }



    }
}