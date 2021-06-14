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

/**
 * classe utilizzata per effettuare il recupero password fornendo la mail dell'account
 */

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

        //viene creata un'istanza di FirebaseAuth
        auth = FirebaseAuth.getInstance()

        //al click sul bottone Resetta Password viene lanciata la funzione resetPassword()
        resetPasswordButton.setOnClickListener {
                resetPassword()
            }
        }

    /**
     * Questa funzione viene utilizzata per effettuare il reset della password
     *
     */
    private fun resetPassword() {
        val email = emailEditText.text.toString().trim()

        //vengono effettuati dei controlli per vedere se l'email è stata inserita o meno
        if(email.isEmpty()){
            emailEditText.error = "Inserisci l'e-mail"
            emailEditText.requestFocus()
            return
        }

        //vengono effettuati dei controlli per vedere se l'email è stata inserita correttamente
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.error = "Inserisci un formato e-mail valido"
            emailEditText.requestFocus()
            return
        }

        progressBar.visibility = View.VISIBLE

        //prendiamo l'istanza della classe FirebaseAuth per lanciare il metodo sendPasswordResetEmail
        auth.sendPasswordResetEmail(email).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                //se il tutto va a buon fine, viene inviata una mail con un link per il reset della password
                Toast.makeText(this, "Controlla la tua mail per resettare la password", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                //se qualcosa va storto, la mail non viene inviata
                Toast.makeText(this, "Riprova, qualcosa è andato storto", Toast.LENGTH_LONG).show()
            }
        }
    }
}

