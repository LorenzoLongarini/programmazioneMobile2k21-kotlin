package com.example.easycooking.memory.ricettaTua


import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*

import com.example.easycooking.R
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream
import java.util.*
import kotlin.properties.Delegates
import android.Manifest

import android.content.pm.PackageManager

import android.widget.Button

import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

const val PERMISSION_REQUEST_CAMERA = 1
const val PERMISSION_REQUEST_GALLERY = 0

private lateinit var editorNomeView: EditText
private lateinit var photoview:ImageButton
private lateinit var editorProcedimento:EditText
private lateinit var editorPrepTime:EditText
private lateinit var editorCookTime:EditText
private lateinit var editorPorzioni:EditText
private lateinit var editorIngr:EditText
var ivImage=""
var aiutolettura =2

private val REQUEST_IMAGE_CAPTURE = 1
private val REQUEST_PICK_IMAGE = 2

/**
 * Questa classe ci permette di aggiungere una ricetta che verrà poi salvata nel database locale
 */

class Inserisci_ricetta : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback  {
    companion object {
        const val EXTRAs_REPLY = "com.example.android.ricettalistsql.REPLY"
    }
    private lateinit var layout: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scriviricetta)
        layout=findViewById(R.id.mainn)

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

        aiutolettura = 2

        //andiamo a salvare l'immagine della ricetta inserita dall'utente, all'interno del medesimo campo
         photoview.setOnClickListener {
             fun showAlertDialogButtonClicked(view: View?) {
                 // viene configurata la AlertDialog
                 val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                 builder.setTitle("Scegli:")

                 //viene aggiunta una lista
                 val scelte = arrayOf("Scatta Foto", "Scegli dalla galleria")
                 builder.setItems(scelte, object : DialogInterface.OnClickListener {
                     override fun onClick(dialog: DialogInterface?, which: Int) {
                         when (which) {
                             0 -> {
                                 showCameraPreview()
                             }
                             1 -> {
                                 showGalleryPreview()
                             }
                         }
                     }
                 })

                 // viene creato e mostrato l'AlertDialog
                 val dialog: AlertDialog = builder.create()
                 dialog.show()
             }
             //l'AlertDialog viene mostrato quando l'utente clicca sul bottone per aggiungere l'immagine
             showAlertDialogButtonClicked(it)
         }



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
                replyIntent.putExtra("photo", ivImage)
                replyIntent.putExtra("aiutolettura", aiutolettura)
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

    /**
     * attraverso questa funzione andiamo a verificare se l'utente che sta inserendo la ricetta,
     * nel momento in cui va a inserire l'immagine della ricetta, concede o meno i permessi
     * di accesso alla galleria e alla fotocamera
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        //permessi fotocamera
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            // richiesta dei permessi per accedere alla fotocamera
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // il permesso viene concesso, viene lanciata la funzione startCamera() che apre la fotocamera
                startCamera()
            } else {
                // il permesso è stato negato
                ivImage="https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Red_x.svg/1200px-Red_x.svg.png"
                aiutolettura=1
                photoview.setImageResource(R.drawable.divieto)
                photoview.drawable.setTintList(null)
            }
        }
        //permessi galleria
        if (requestCode == PERMISSION_REQUEST_GALLERY) {
            // richeista dei permssi per accedere alla galleria
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // il permesso viene concesso, viene lanciata la funzione startGallery() che apre la galleria
                startGallery()
            } else {
                // il permesso è stato negato
                ivImage="https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Red_x.svg/1200px-Red_x.svg.png"
                aiutolettura=1
                photoview.setImageResource(R.drawable.divieto)
                photoview.drawable.setTintList(null)
            }
        }
    }

    /**
     * attraverso questa funzione andiamo a controllare se l'utente ha già concesso o meno i permessi
     * per quanto riguarda l'accesso alla fotocamera
     */
    private fun showCameraPreview() {
        // si controlla se l'accesso alla fotocamera è stato già concesso
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
            PackageManager.PERMISSION_GRANTED) {
            //i permessi per la l'accesso alla fotocamera sono stati già concessi, viene lanciata la funzione startCamera()
            startCamera()
        } else {
            //i permessi non sono stati ancora concessi, viene lanciata la funzione requestCameraPermission()
            requestCameraPermission()
        }
    }

    /**
     * attraverso questa funzione andiamo a controllare se l'utente ha già concesso o meno i permessi
     * per quanto riguarda l'accesso alla galleria
     */
    private fun showGalleryPreview() {
        // si controlla se l'accesso alla galleria è stato già concesso
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
            PackageManager.PERMISSION_GRANTED) {
            //i permessi per l'accesso alla galleria sono stati già concessi, viene lanciata la funzione startGAllery()
            startGallery()
        } else {
            //i permessi non sono stati ancora concessi, viene lanciata la funzione requestGalleryPermission()
            requestGalleryPermission()
        }
    }

    /**
     * questa funzione viene lanciata quando non sono stati ancora concessi i permessi alla fotocamera
     */
    private fun requestCameraPermission() {
        // il permesso di accesso alla fotocamera non è ancora stato concesso
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.

        } else {

            //Viene richiesto il permesso di accesso alla fotocamera.
            //L'esito della richiesta verrà trasmesso in onRequestPermissionResult()
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA), PERMISSION_REQUEST_CAMERA)
        }
    }

    private fun requestGalleryPermission() {
        // il permesso di accesso alla galleria non è ancora stato concesso
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.

        } else {

            //Viene richiesto il permesso di accesso alla galleria.
            //L'esito della richiesta verrà trasmesso in onRequestPermissionResult()
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_GALLERY)
        }
    }

    /**
     * questa funzione viene lanciata per dare l'accesso alla fotocamera
     */
    private fun startCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            intent.resolveActivity(packageManager)?.also {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    /**
     * questa funzione viene lanciata per dare l'accesso alla galleria
     */
    private fun startGallery() {
        Intent(Intent.ACTION_OPEN_DOCUMENT).also { intent ->
            intent.type = "image/*"
            intent.resolveActivity(packageManager)?.also {
                startActivityForResult(intent, REQUEST_PICK_IMAGE)
            }
        }
    }

    /**
     * Attraverso onActivityResult, viene effettuato un controllo per verificare se l'utente
     * ha accettato o meno i consensi di accesso alla fotocamera o galleria
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                val bitmap = data?.extras?.get("data") as Bitmap
                ivImage=bitmapToBase64(bitmap)
                aiutolettura=0
            } else if (requestCode == REQUEST_PICK_IMAGE) {
                val uri = data?.getData()
                ivImage=uri.toString()
                aiutolettura=1
            }
        }

        photoview.setImageResource(R.drawable.thumbs_up)
        photoview.drawable.setTintList(null)

    }

    /**
     * Questa funzione converte l'immagine da bitmap in una stringa,
     * così che possa essere salvata nella room
     *
     */
    private fun bitmapToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray: ByteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}
