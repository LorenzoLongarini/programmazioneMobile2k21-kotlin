package com.example.easycooking.memory.spesa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.R

class Activity_compra : AppCompatActivity() {

    private lateinit var editorNomeView: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)
        editorNomeView=findViewById(R.id.nome_prodotto_inserimento)


        val bt: Button =findViewById<Button>(R.id.bottone_aggiungi_inserimento)
        bt.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editorNomeView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val nomeprod = editorNomeView.text.toString()
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