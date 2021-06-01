package com.example.easycooking.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.room.Room

import com.example.easycooking.DB.DispensaDBEntity
import com.example.easycooking.R

class Activity_inserisci_dispensa : AppCompatActivity() {

    private lateinit var editorNomeView:EditText
    //private lateinit var editorQuantView:EditText
    //private lateinit var editorUnitView:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserisci_in_dispensa)
        editorNomeView=findViewById(R.id.nome_prodotto_inserimento)
        //editorQuantView=findViewById(R.id.quantita_prodotto_inserimento)
        //editorUnitView=findViewById(R.id.unita_inserimento)

        val bt:Button=findViewById<Button>(R.id.bottone_aggiungi_inserimento)
        bt.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editorNomeView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val nomeprod = editorNomeView.text.toString()
                //val quant = editorQuantView.text.toString()
                //val unit = editorUnitView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, nomeprod)
                //replyIntent.putExtra("quant",quant)
                //replyIntent.putExtra("unit",unit)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.dispensalistsql.REPLY"
    }
}