package com.example.easycooking.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.MainActivity
import com.example.easycooking.R
import com.example.easycooking.view.Base
import com.example.easycooking.view.Base_nonReg
import com.example.easycooking.view.Log_in_base
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registrati.*
import java.util.*


class RegistrationActivity : AppCompatActivity() {
    private lateinit var textNome: TextInputEditText
    private lateinit var textCognome: TextInputEditText
    private lateinit var textEmail: TextInputEditText
    private lateinit var textPassword: TextInputEditText

    private lateinit var btnRegistra: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrati)
        mAuth = FirebaseAuth.getInstance()
        textNome = findViewById(R.id.text_nome)
        textCognome = findViewById(R.id.text_cognome)
        textEmail = findViewById(R.id.text_email)
        textPassword = findViewById(R.id.text_password)
        btnRegistra = findViewById(R.id.btn_registra)
        btnRegistra.setOnClickListener {
            try {
                val nome = textNome.text.toString()
                val cognome = textCognome.text.toString()
                val email = textEmail.text.toString()
                val password = textPassword.text.toString()
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser = mAuth.currentUser
                        val profileChangeRequest: UserProfileChangeRequest = UserProfileChangeRequest.Builder()
                            .setDisplayName("$nome $cognome")
                            .build()
                        user.updateProfile(profileChangeRequest).addOnCompleteListener {
                            writeUserToDb(nome, cognome, user.uid)
                            val intent = Intent()
                            intent.putExtra("nome", textNome.text.toString())
                            intent.putExtra("cognome", textCognome.text.toString())
                            setResult(Activity.RESULT_OK, intent)
                            finish()
                            val intent1 = Intent(this, Base::class.java)
                            startActivity(intent1)
                        }
                    } else {
                        task.exception!!.printStackTrace()
                        Toast.makeText(this@RegistrationActivity, getString(R.string.errorsignup), Toast.LENGTH_SHORT).show()

                    }
                }
            } catch (e: Exception) {
                if(TextUtils.isEmpty(textNome.text.toString()) && TextUtils.isEmpty(textCognome.text.toString()) && TextUtils.isEmpty(textEmail.text.toString()) && TextUtils.isEmpty(textPassword.text.toString())){
                    textNome.setError("Per favore inserisci il tuo nome")
                    textCognome.setError("Per favore inserisci il tuo cognome")
                    textEmail.setError("Per favore inserisci la tua mail")
                    textPassword.setError("Per favore inserisci una password composta da almeno 6 caratteri o numeri")
                    return@setOnClickListener
                }
                else if(TextUtils.isEmpty(textNome.text.toString())){
                    textNome.setError("Per favore inserisci il tuo nome")
                    return@setOnClickListener
                }
                else if(TextUtils.isEmpty(textCognome.text.toString())){
                    textCognome.setError("Per favore inserisci il tuo cognome")
                    return@setOnClickListener
                }
                else if(TextUtils.isEmpty(textEmail.text.toString())){
                    textEmail.setError("Per favore inserisci la tua mail")
                    return@setOnClickListener
                }
                else if(TextUtils.isEmpty(textPassword.text.toString())){
                    textPassword.setError("Per favore inserisci una password composta da almeno 6 caratteri o numeri")
                    return@setOnClickListener
                }

            }
        }
        accedi_registrati.setOnClickListener{
        val intent2 = Intent(this, MainActivity::class.java)
        startActivity(intent2)
        supportActionBar!!.setTitle(getString(R.string.registrati))
    }
    }

    private fun writeUserToDb(nome: String, cognome: String, uid: String) {
        val user: MutableMap<String, Any> = HashMap()
        user["nome"] = nome
        user["cognome"] = cognome
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("utenti").document(uid).set(user)
    }

}