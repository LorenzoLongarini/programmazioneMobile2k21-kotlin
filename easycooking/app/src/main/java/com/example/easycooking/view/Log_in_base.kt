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
import com.example.easycooking.R
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.auth.api.signin.internal.zzi
import com.google.android.gms.auth.api.signin.internal.zzi.getSignInResultFromIntent
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


class Log_in_base : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var signInButton: SignInButton
    private lateinit var googleSignInClient: GoogleSignInClient
    private val TAG: String = "SignInActivity"
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_log_in_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = activity?.let { GoogleSignIn.getClient(it, gso) }!!
        signInButton = view.findViewById(R.id.bottone_gmail2)
        signInButton.setOnClickListener{onClick(signInButton)}
        auth = FirebaseAuth.getInstance()
        login()
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
            val result: GoogleSignInResult = getSignInResultFromIntent(data)!!
            handleSignInResult(result)


        }
    }

    private fun handleSignInResult(result: GoogleSignInResult) {
        Log.d(TAG, "handleSignInResult:"+ result.isSuccess)
        if(result.isSuccess){
            val acct: GoogleSignInAccount? = result.getSignInAccount()
            val intent = Intent(activity, Base::class.java)
            startActivity(intent)

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
}
