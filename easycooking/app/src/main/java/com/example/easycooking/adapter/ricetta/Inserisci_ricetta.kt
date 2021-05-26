package com.example.easycooking.adapter.ricetta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.easycooking.R
private lateinit var editorNomeView: EditText
class Inserisci_ricetta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inserisci_ricetta)

        editorNomeView=findViewById(R.id.nomeric)


        val bt: Button =findViewById<Button>(R.id.salvaRicetta)
        bt.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editorNomeView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val nomeric= editorNomeView.text.toString()
                replyIntent.putExtra(EXTRAs_REPLY, nomeric)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRAs_REPLY = "com.example.android.ricettalistsql.REPLY"
    }
}