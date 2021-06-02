package com.example.easycooking.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil.setContentView
import com.example.easycooking.R
import com.example.easycooking.auth.RegistrationActivity
import com.example.easycooking.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.auth.api.signin.internal.zzi
import com.google.android.gms.auth.api.signin.internal.zzi.getSignInResultFromIntent
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.bottone_accedi
import kotlinx.android.synthetic.main.activity_main.email_accedi
import kotlinx.android.synthetic.main.activity_main.psw_accedi
import kotlinx.android.synthetic.main.fragment_log_in_base.*


class Log_in_base : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var signInButton: SignInButton
    private lateinit var googleSignInClient: GoogleSignInClient
    private val TAG: String = "SignInActivity"
    private val RC_SIGN_IN = 9001


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_log_in_base, container, false)
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Login"
        auth = FirebaseAuth.getInstance()
        createRequest()
       bottone_gmail2.setOnClickListener { onClick(bottone_gmail2) }

        login()
        registratiView1()
    }

    private fun createRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = activity?.let { GoogleSignIn.getClient(it, gso) }!!
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
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
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)

                }

                val intent = Intent(activity, Base::class.java)
                startActivity(intent)
            }
            .addOnFailureListener(OnFailureListener {
                Log.d(TAG, "failure")
            })
    }

    fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bottone_gmail2 -> signIn()
        }
    }

    companion object {
        fun newInstance(): RicetteTue {
            return RicetteTue()
                }
            }

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
                        val intent = Intent(activity, Base::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(activity, "Login fallito", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }


    private fun registratiView1() {
        registrati_accedi1.setOnClickListener {
            val intent2 = Intent(activity, RegistrationActivity::class.java)
            startActivity(intent2)
        }
    }
}
