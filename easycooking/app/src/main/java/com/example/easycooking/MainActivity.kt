package com.example.easycooking


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.easycooking.view.Base
import com.example.easycooking.view.RicetteCerca
import com.google.firebase.auth.FirebaseAuth
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.auth.api.signin.internal.zzi.getSignInResultFromIntent
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.example.easycooking.auth.RegistrationActivity
import com.example.easycooking.view.Base_nonReg
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_logout.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

        private lateinit var auth: FirebaseAuth
        private lateinit var signInButton: SignInButton
        private lateinit var googleSignInClient: GoogleSignInClient
        private val TAG: String = "SignInActivity"
        private val RC_SIGN_IN = 9001

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            auth = FirebaseAuth.getInstance()

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(this, gso)
            signInButton = findViewById(R.id.bottone_gmail)
            signInButton.setOnClickListener(this)
            login()
            resetPassword()
        }

        private fun signIn() {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
            if (requestCode == RC_SIGN_IN) {
                // The Task returned from this call is always completed, no need to attach
                // a listener.
                val result: GoogleSignInResult  = getSignInResultFromIntent(data)!!
                handleSignInResult(result)
                val intent = Intent(this, Base::class.java)
                startActivity(intent)
            }
        }

        private fun handleSignInResult(result: GoogleSignInResult) {
            Log.d(TAG, "handleSignInResult:"+ result.isSuccess)
            if(result.isSuccess){
                val acct: GoogleSignInAccount? = result.getSignInAccount()

            }else{

            }
        }

        fun onConnectionFailed(connectionResult: ConnectionResult){
            Log.d(TAG, "onConnectionFailed:" + connectionResult)
        }


        private fun signOut() {
         // [START auth_sign_out]
            Firebase.auth.signOut()
            // [END auth_sign_out]
        }

        override fun onClick(v: View?) {
         when (v!!.id) {
            R.id.bottone_gmail -> signIn()
            }
        }

        //login
        private fun login(){
            bottone_accedi.setOnClickListener{
                if(TextUtils.isEmpty(email_accedi.text.toString())){
                    email_accedi.setError("Per favore inserisci una mail valida")
                    return@setOnClickListener
                }
                else if(TextUtils.isEmpty(psw_accedi.text.toString())){
                    email_accedi.setError("Per favore inserisci una password valida")
                    return@setOnClickListener
                }
                auth.signInWithEmailAndPassword(email_accedi.text.toString(), psw_accedi.text.toString())
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, Base::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this@MainActivity, "Login fallito", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }

        //intent
        fun senzaReg(v: View) {
         val intent = Intent(this, Base_nonReg::class.java)
            startActivity(intent)
         }
        fun registratiView(v: View) {
            val intent2 = Intent(this, RegistrationActivity::class.java)
         startActivity(intent2)
        }

        private fun resetPassword(){

            password_dimenticata.setOnClickListener {
            val emailAddress = email_accedi

            Firebase.auth.sendPasswordResetEmail(emailAddress.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Email sent.")
                    }
                }
            }
        }

}