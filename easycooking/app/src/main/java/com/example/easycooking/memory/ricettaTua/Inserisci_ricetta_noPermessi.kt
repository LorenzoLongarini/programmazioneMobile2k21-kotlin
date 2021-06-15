package com.example.easycooking.memory.ricettaTua


import android.app.Activity

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.*

import com.example.easycooking.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


private lateinit var editorNomeView: EditText
private lateinit var photoview:ImageButton
private lateinit var editorProcedimento:EditText
private lateinit var editorPrepTime:EditText
private lateinit var editorCookTime:EditText
private lateinit var editorPorzioni:EditText
private lateinit var editorIngr:EditText

/**
 * Questa classe ci permette di aggiungere una ricetta che verrà poi salvata nel database locale
 */

class Inserisci_ricetta_noPermessi : AppCompatActivity() {
    companion object {
        const val EXTRAs_REPLY = "com.example.android.ricettalistsql.REPLY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scriviricetta)

        editorNomeView = findViewById(R.id.nome_ricetta_inserimento)
        photoview = findViewById(R.id.imageButton3)
        editorProcedimento = findViewById(R.id.editTextTextMultiLine)
        editorPrepTime = findViewById(R.id.prep_inserimento)
        editorCookTime = findViewById(R.id.cott_inserimento)
        editorPorzioni = findViewById(R.id.editTextNumber)
        editorIngr = findViewById(R.id.Ingrediente_1)

        //andiamo a salvare la preparazione della ricetta inserita dall'utente nella form, all'interno del medesimo campo
        editorPrepTime.addTextChangedListener(object : TextWatcher {
            var len = 0
            override fun afterTextChanged(s: Editable) {
                val str: String = editorPrepTime.text.toString()
                if (str.length == 2 && len < str.length) { //len check for backspace
                    editorPrepTime.append(":")
                }
                if (str.length == 5 && len < str.length) { //len check for backspace
                    editorPrepTime.append(":")
                }

            }

            override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {
                val str: String = editorPrepTime.text.toString()
                len = str.length
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        //andiamo a salvare il tempo della ricetta inserita dall'utente nella form, all'interno del medesimo campo
        editorCookTime.addTextChangedListener(object : TextWatcher {
            var len = 0
            override fun afterTextChanged(s: Editable) {
                val str: String = editorCookTime.text.toString()
                if (str.length == 2 && len < str.length) { //len check for backspace
                    editorCookTime.append(":")
                }
                if (str.length == 5 && len < str.length) { //len check for backspace
                    editorCookTime.append(":")
                }

            }

            override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {
                val str: String = editorCookTime.text.toString()
                len = str.length
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })


        photoview.setImageResource(R.drawable.divieto)
        photoview.drawable.setTintList(null)


        var Ingredienti: ArrayList<String> = arrayListOf()
        var add = findViewById<Button>(R.id.addingr)

        //andiamo a salvare gli ingredienti della ricetta inserita dall'utente, all'interno del medesimo campo
        add.setOnClickListener { view ->
            var appo = editorIngr.text.toString()
            Ingredienti.add(appo)
            editorIngr.text.clear()
            Toast.makeText(applicationContext, "$appo è stato aggiunto", Toast.LENGTH_SHORT).show()
        }

        val bt: Button = findViewById<Button>(R.id.salvaRicetta)

        //viene quindi salvata la ricetta
        bt.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editorNomeView.text)) {
                //se il nome della ricetta non viene inserito, la ricetta non viene salvata
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                var tempoprep = editorPrepTime.text.toString()
                var tempocott = editorCookTime.text.toString()
                var oreCott = tempocott.subSequence(0, 2)
                var minCott = tempocott.subSequence(3, 5)
                var secCott = tempocott.subSequence(6, 8)
                var orePrep = tempoprep.subSequence(0, 2)
                var minPrep = tempoprep.subSequence(3, 5)
                var secPrep = tempoprep.subSequence(6, 8)

                var oreTot = (oreCott.toString().toInt()) + (orePrep.toString().toInt())
                var minTot = (minCott.toString().toInt()) + (minPrep.toString().toInt())
                var secTot = (secCott.toString().toInt()) + (secPrep.toString().toInt())
                if (secTot >= 60) {
                    secTot -= 60
                    minTot += 1
                }
                if (minTot >= 60) {
                    minTot -= 60
                    oreTot += 1
                }

                var tempoTot: String =
                    oreTot.toString() + ":" + minTot.toString() + ":" + secTot.toString()
                var strIngr = ""
                for (ingr in Ingredienti) {
                    strIngr += ingr + "\n"
                }


                val nomeric = editorNomeView.text.toString()
                replyIntent.putExtra(EXTRAs_REPLY, nomeric)
                replyIntent.putExtra("photo", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Red_x.svg/1200px-Red_x.svg.png")
                replyIntent.putExtra("aiutolettura", 1)
                replyIntent.putExtra("procedimento", editorProcedimento.text.toString())
                replyIntent.putExtra("tempo_prep", editorPrepTime.text.toString())
                replyIntent.putExtra("tempo_cott", editorCookTime.text.toString())
                replyIntent.putExtra("tempo_tot", tempoTot)
                replyIntent.putExtra("porzioni", editorPorzioni.text.toString())
                replyIntent.putExtra("ingredienti", strIngr)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }


    }

