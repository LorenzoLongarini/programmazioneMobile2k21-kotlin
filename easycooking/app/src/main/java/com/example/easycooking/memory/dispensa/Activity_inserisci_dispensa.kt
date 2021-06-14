package com.example.easycooking.memory.dispensa

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

import com.example.easycooking.R

/**
 * in questa activity viene effettuato l'inserimento di un nuovo prodotto in dispensa
 *
 */

class Activity_inserisci_dispensa : AppCompatActivity() {

    private lateinit var editorNomeView:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserisci_in_dispensa)
        editorNomeView=findViewById(R.id.nome_prodotto_inserimento)

        val bt:Button=findViewById<Button>(R.id.bottone_aggiungi_inserimento)
        //cliccando sul bottone aggiungi, viene inserito il prodotto nella dispensa
        bt.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editorNomeView.text)) {
                //se si clicca sul bottone Aggiungi ma non si inserisce alcun prodotto, viene annullato l'inserimento
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                //il prodotto viene inserito in dispensa
                val nomeprod = editorNomeView.text.toString().toLowerCase()
                replyIntent.putExtra(EXTRA_REPLY, nomeprod)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.dispensalistsql.REPLY"
    }
}