package com.example.easycooking.auth

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
import com.example.easycooking.R
import com.example.easycooking.view.Base
import com.example.easycooking.view.RicetteTue
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.bottone_accedi
import kotlinx.android.synthetic.main.activity_main.email_accedi
import kotlinx.android.synthetic.main.activity_main.psw_accedi
import kotlinx.android.synthetic.main.fragment_log_in_base.*

/**
 * questa classe viene utilizzata per lanciare il fragment che permette di effettuare l'accesso,
 * la registrazione o il recupero password dopo che l'utente ha deciso di usufruire della app
 * senza effettuare la registrazione o il login all'avvio della app
 */


class Log_in_base : Fragment() {

    private lateinit var auth: FirebaseAuth
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
        //viene lanciata la funzione createRequest() per accedere alle informazioni riguardanti l'account google dell'utente
        createRequest()

        //andiamo a settare il click del bottone per il sign-in con google
        bottone_gmail2.setOnClickListener { onClick(bottone_gmail2) }

        //viene richiamata la funzione che permette all'utente di effettuare il login
        login()

        //viene richiamata la funzione che permette all'utente di registrarsi
        registratiView1()

        //viene richiamata la funzione che permette all'utente di resettare la password
        resetPassword1()
    }

    //configurazione google sign-in attraverso una richiesta dell'ID utente, indirizzo e-mail e informazioni di base riguardanti il profilo utente
    //ID e informazioni di base riguardante il profilo utente sono inclusi in DEFAULT_SIGN_IN
    private fun createRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        //crea un GoogleSignInClient con le specifiche date da gso
        googleSignInClient = activity?.let { GoogleSignIn.getClient(it, gso) }!!
    }

    /**
     * Attraverso questa funzione viene lanciato un intent per aprire una finestra di dialogo
     * per scegliere l'account google con cui l'utente vuole effettuare l'accesso.
     *
     */
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    /**
     * Dopo che l'utente ha effettuato l'accesso, si ottiene un oggetto GoogleSignInAccount per l'utente
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Risultato ottenuto dal lancio dell intent da GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // accesso con Google Sign In riuscito, l'account viene salvato su firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // accesso con Google Sign In non riuscito
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    /**
     * Dopo che l'utente ha eseguito l'accesso si ottiene un token id dall'oggetto GoogleSignInAccount
     * l'ggetto  GoogleSignInAccount contiene quindi informazioni sull'utente
     *
     */
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in avvenuto con successo
                    Log.d(TAG, "signInWithCredential:success")

                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)

                }

                //viene quindi lanciato un intent che ci porta all'activity vase
                val intent = Intent(activity, Base::class.java)
                startActivity(intent)
            }
            .addOnFailureListener(OnFailureListener {
                Log.d(TAG, "failure")
            })
    }

    /**
     * Al click del bottone che ci permette di fare l'accesso con google, viene lanciata la funzione signIn()
     *
     */
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

    /**
     * Questa funzione ci permette di effettuare il login attraverso credenziali gia esistenti nel nostro database
     *
     */
    private fun login(){
        bottone_accedi.setOnClickListener{
            //effettuiamo i controlli per vedere se l'utente inserisce o meno le credenziali dopo aver cliccato sul bottone accedi
            if(TextUtils.isEmpty(email_accedi.text.toString()) && TextUtils.isEmpty(psw_accedi.text.toString())){
                email_accedi.error = "Per favore inserisci la tua mail"
                psw_accedi.error = "Per favore inserisci la tua password"
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(email_accedi.text.toString())){
                email_accedi.error = "Per favore inserisci la tua mail"
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(psw_accedi.text.toString())){
                psw_accedi.error = "Per favore inserisci la tua password"
                return@setOnClickListener
            }

            //prendiamo l'istanza della classe FirebaseAuth per lanciare il metodo signInWithEmailAndPassword
            auth.signInWithEmailAndPassword(email_accedi.text.toString(), psw_accedi.text.toString())
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        //se le credenziali sono inserite correttamente, l'utente è loggato e viene lanciata l'activity riservata ai soli utenti registrati
                        val intent = Intent(activity, Base::class.java)
                        startActivity(intent)
                    }else{
                        //se le credenziali non sono inserite correttamente, appare un messaggio di errore
                        Toast.makeText(activity, "Login fallito", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    /**
     * questa funzione lancia un intent che ci permette di accedere all'activity per effettuare la registrazione
     *
     */
    private fun registratiView1() {
        registrati_accedi1.setOnClickListener {
            val intent2 = Intent(activity, RegistrationActivity::class.java)
            startActivity(intent2)
        }
    }

    /**
     * questa funzione lancia un intent che ci permette di accedere all'activity per il recupero password
     *
     */
    private fun resetPassword1() {
        password_dimenticata1.setOnClickListener{
            val intent = Intent(activity, ResetPassword::class.java)
            startActivity(intent)
        }
    }
}
