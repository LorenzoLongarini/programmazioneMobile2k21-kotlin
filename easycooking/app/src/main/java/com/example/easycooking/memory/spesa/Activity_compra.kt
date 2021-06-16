package com.example.easycooking.memory.spesa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.R

/**
 * Questa classe permette di lanciare un'activity che ci consente
 * di inserire un prodotto nella lista della spesa
 */

class Activity_compra : AppCompatActivity() {

    private lateinit var editorNomeView: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)
        editorNomeView=findViewById(R.id.nome_prodotto_inserimento)


        val bt: Button =findViewById<Button>(R.id.bottone_aggiungi_inserimento)
        //al click del bottone Inserisci, viene effettuato l'inserimento nella lista della spesa,
        //a meno di errori di inserimento
        bt.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editorNomeView.text)) {
                //se la casella di testo è vuota, il prodotto non viene inserito
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                //il prodotto viene inserito nella lista della spesa
                val nomeprod = editorNomeView.text.toString().toLowerCase()
                replyIntent.putExtra(EXTRAs_REPLY, nomeprod)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRAs_REPLY = "com.example.android.spesalistsql.REPLY"
    }
}