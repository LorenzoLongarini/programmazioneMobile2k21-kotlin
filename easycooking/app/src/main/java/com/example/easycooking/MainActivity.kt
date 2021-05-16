package com.example.easycooking


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.auth.RegistrationActivity
import com.example.easycooking.view.Base
import com.example.easycooking.view.Base_nonReg
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.auth.api.signin.internal.zzi.getSignInResultFromIntent
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import androidx.databinding.DataBindingUtil
import com.example.easycooking.databinding.ActivityMainBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var signInButton: SignInButton
    private lateinit var googleSignInClient: GoogleSignInClient
    private val TAG: String = "SignInActivity"
    private val RC_SIGN_IN = 100
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRequest()

        auth = FirebaseAuth.getInstance()

        binding.bottoneGmail.setOnClickListener { onClick(bottone_gmail) }

        login()
    }

    private fun createRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)

                }

                val intent = Intent(this, Base::class.java)
                startActivity(intent)
                finish()
            }
            .addOnFailureListener(OnFailureListener {
                Log.d(TAG, "failure")
            })
    }

    fun onConnectionFailed(connectionResult: ConnectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult)
    }


    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bottone_gmail -> signIn()
        }
    }


    //login
    private fun login() {
        bottone_accedi.setOnClickListener {
            if (TextUtils.isEmpty(email_accedi.text.toString())) {
                email_accedi.setError("Per favore inserisci una mail valida")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(psw_accedi.text.toString())) {
                email_accedi.setError("Per favore inserisci una password valida")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(
                email_accedi.text.toString(),
                psw_accedi.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, Base::class.java)
                        startActivity(intent)
                        finish()
                    } else {
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

}



/*
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.auth.RegistrationActivity
import com.example.easycooking.view.Base
import com.example.easycooking.view.Base_nonReg
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.auth.api.signin.internal.zzi.getSignInResultFromIntent
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import androidx.databinding.DataBindingUtil
import com.example.easycooking.databinding.ActivityMainBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener {

        private lateinit var auth: FirebaseAuth
        private lateinit var signInButton: SignInButton
        private lateinit var googleSignInClient: GoogleSignInClient
        private val TAG: String = "SignInActivity"
        private val RC_SIGN_IN = 100


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            createRequest()

            auth = FirebaseAuth.getInstance()

            signInButton = findViewById(R.id.bottone_gmail)
            signInButton.setOnClickListener(this)

            login()
        }

        private fun createRequest() {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken( getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(this, gso)
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
        }
    }

    private fun handleSignInResult(result: GoogleSignInResult) {
        Log.d(TAG, "handleSignInResult:"+ result.isSuccess)
        if(result.isSuccess){
            val acct: GoogleSignInAccount? = result.getSignInAccount()
        }else{

        }
        val intent = Intent(this, Base::class.java)
        startActivity(intent)
    }

    fun onConnectionFailed(connectionResult: ConnectionResult){
        Log.d(TAG, "onConnectionFailed:" + connectionResult)
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


}
*/
