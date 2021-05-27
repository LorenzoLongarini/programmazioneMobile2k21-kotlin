package com.example.easycooking.adapter.ricetta

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.R


var fotoscelta:String=""
private lateinit var editorNomeView: EditText
private lateinit var photoview:ImageButton
class Inserisci_ricetta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scriviricetta)

        editorNomeView=findViewById(R.id.nome_ricetta_inserimento)
        photoview=findViewById<ImageButton>(R.id.imageButton3)

        photoview.setOnClickListener {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "select a picture"), YOUR_IMAGE_CODE)
        }

        var add = findViewById<Button>(R.id.addingr)
        var n=1
            add.setOnClickListener { view ->
                val editText = EditText(this)
                n=n+1
                editText.id=n
                val lay=findViewById<LinearLayout>(R.id.edit_texts_container).addView(editText)
            }


        val bt: Button =findViewById<Button>(R.id.salvaRicetta)
        bt.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editorNomeView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val nomeric= editorNomeView.text.toString()
                replyIntent.putExtra(EXTRAs_REPLY, nomeric)
                replyIntent.putExtra("photo", fotoscelta)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == YOUR_IMAGE_CODE) {
            if(resultCode == RESULT_OK) {
                var selectedImageUri: Uri? = data?.data
                fotoscelta=selectedImageUri.toString()
            }
        }
    }

    companion object {
        const val EXTRAs_REPLY = "com.example.android.ricettalistsql.REPLY"
        const val YOUR_IMAGE_CODE = 192
    }
}