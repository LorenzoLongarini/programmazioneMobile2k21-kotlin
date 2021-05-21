package com.example.easycooking.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.easycooking.R

class Activity_gestione : AppCompatActivity() {
    private lateinit var editorQuantView: EditText
    private lateinit var editorUnitView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestione)
        editorQuantView=findViewById(R.id.quantita_prodotto_inserimento)
        editorUnitView=findViewById(R.id.unita_inserimento)

        val bt: Button =findViewById<Button>(R.id.bottone_aggiungi_inserimento)
        bt.setOnClickListener {
            val replyIntent = Intent()
                val quant = editorQuantView.text.toString()
                val unit = editorUnitView.text.toString()
                replyIntent.putExtra("quant",quant)
                replyIntent.putExtra("unit",unit)
            finish()
            }

        }
}