package com.example.easycooking

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class LoginActivity : AppCompatActivity() {

    private lateinit var textNome: TextInputEditText
    private lateinit var textCognome: TextInputEditText
    private lateinit var textEmail: TextInputEditText
    private lateinit var textPassword: TextInputEditText

    private lateinit var btnRegistra: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
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
                        val user = mAuth.currentUser
                        val profileChangeRequest = UserProfileChangeRequest.Builder()
                                .setDisplayName("$nome $cognome")
                                .build()
                        user.updateProfile(profileChangeRequest).addOnCompleteListener {
                            writeUserToDb(nome, cognome, user.uid)
                            val intent = Intent()
                            intent.putExtra("nome", textNome.text.toString())
                            intent.putExtra("cognome", textCognome.text.toString())
                            setResult(Activity.RESULT_OK, intent)
                            finish()
                        }
                    } else {
                        task.exception!!.printStackTrace()
                        Toast.makeText(this@LoginActivity, getString(R.string.errorsignup), Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this@LoginActivity, getString(R.string.inforequired), Toast.LENGTH_SHORT).show()
            }
        }
        supportActionBar!!.setTitle(getString(R.string.registrati))
    }

    private fun writeUserToDb(nome: String, cognome: String, uid: String) {
        val user: MutableMap<String, Any> = HashMap()
        user["nome"] = nome
        user["cognome"] = cognome
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("utenti").document(uid).set(user)
    }
}
