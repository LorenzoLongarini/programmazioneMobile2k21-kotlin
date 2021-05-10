package com.example.easycooking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.easycooking.view.RicetteCerca
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.auth.api.signin.internal.zzi.getSignInResultFromIntent
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var signInButton: SignInButton
    private lateinit var googleSignInClient: GoogleSignInClient
    private val TAG: String = "SignInActivity"
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        signInButton = findViewById(R.id.bottone_gmail)
        signInButton.setOnClickListener(this)

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
    }

    fun onConnectionFailed(connectionResult: ConnectionResult){
        Log.d(TAG, "onConnectionFailed:" + connectionResult)
    }

    fun senzaReg(v: View) {
        val intent = Intent(this, RicetteCerca::class.java)
        startActivity(intent)
    }

    fun registratiView(v: View) {
        val intent2 = Intent(this, LoginActivity::class.java)
        startActivity(intent2)
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
}