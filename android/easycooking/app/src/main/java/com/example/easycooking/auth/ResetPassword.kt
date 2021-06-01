package com.example.easycooking.auth

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.easycooking.MainActivity
import com.example.easycooking.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference


class ResetPassword : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var resetPasswordButton: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        emailEditText = findViewById(R.id.email_reset)
        resetPasswordButton = findViewById(R.id.buttonReset)
        progressBar = findViewById(R.id.progress_bar)

        auth = FirebaseAuth.getInstance()

        resetPasswordButton.setOnClickListener {
                resetPassword()
            }
        }

    private fun resetPassword() {
        val email = emailEditText.text.toString().trim()

        if(email.isEmpty()){
            emailEditText.error = "Inserisci l'e-mail"
            emailEditText.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.error = "Inserisci un formato e-mail valido"
            emailEditText.requestFocus()
            return
        }

        progressBar.visibility = View.VISIBLE
        auth.sendPasswordResetEmail(email).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                    Toast.makeText(this, "Controlla la tua mail per resettare la password", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
            Toast.makeText(this, "Riprova, qualcosa è andato storto", Toast.LENGTH_LONG).show()
            }
        }
    }
}

