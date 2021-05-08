package com.example.easycooking.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.easycooking.LoginActivity
import com.example.easycooking.R
import com.example.easycooking.view.RicetteCerca
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class EmailPasswordActivity : Activity() {

    // [START declare_auth]
    private lateinit var auth: FirebaseAuth
    // [END declare_auth]
    private lateinit var  accedi: Button
    private lateinit var textEmail: TextInputEditText
    private lateinit var textPassword: TextInputEditText
    /*private val authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
        var value = firebaseAuth.currentUser
    }*/
   /* val authenticationState = FirebaseUserLiveData().map { user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
       }
    }
*/
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        accedi = findViewById(R.id.bottone_accedi)
        textEmail = findViewById(R.id.text_email)
        textPassword = findViewById(R.id.text_password)
        // [START initialize_auth]
        // Initialize Firebase Auth
        auth = Firebase.auth
        // [END initialize_auth]
        //private fun signIn(email: String, password: String) {
        // [START sign_in_with_email]

        accedi.setOnClickListener {
            try {
                val email = textEmail.text.toString()
                val password = textPassword.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            updateUI(user)
                            val intent = Intent(this, RicetteCerca::class.java)
                            startActivity(intent)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    }
            } catch (e: Exception) {
                Toast.makeText(this, getString(R.string.inforequired), Toast.LENGTH_SHORT).show()
            }
           // supportActionBar!!.setTitle(getString(R.string.registrati))
        }
    }


    // [START on_start_check_user]
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }
    // [END on_start_check_user]


        // [END sign_in_with_email]

/*
    private fun sendEmailVerification() {
        // [START send_email_verification]
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // Email Verification sent
            }
        // [END send_email_verification]
    }
*/
    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}