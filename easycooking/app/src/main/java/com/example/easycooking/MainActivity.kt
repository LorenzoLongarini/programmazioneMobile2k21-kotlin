package com.example.easycooking


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.TextView
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
import com.example.easycooking.auth.ResetPassword
import com.example.easycooking.databinding.ActivityMainBinding
import com.example.easycooking.view.Base_nonReg
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_logout.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

        private lateinit var auth: FirebaseAuth
        private lateinit var googleSignInClient: GoogleSignInClient
        private lateinit var forgotPassword: TextView
        private val TAG: String = "SignInActivity"
        private val RC_SIGN_IN = 9001

        //crea il binding
        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            //inizializziamo la viariabile auth attraverso FirebaseAuth.getInstance()
            auth = FirebaseAuth.getInstance()

            //otteniamo la view utilizzando un layoutInflater
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //viene lanciata la funzione createRequest() per accedere alle informazioni riguardanti l'account google dell'utente
            createRequest()

            //viene inizializzata un'istanza di FirebaseAuth
            auth = FirebaseAuth.getInstance()

            //usiamo l'istanza della classe Binding per settare il click del bottone GoogleSignIn
            binding.bottoneGmail.setOnClickListener {
                onClick(bottone_gmail)
            }

            forgotPassword = findViewById(R.id.password_dimenticata)
            //al click sulla scritta "Hai dimenticato la password?" viene lanciato l'intent che ci rimanda all'activity per il reset della password
            forgotPassword.setOnClickListener{startActivity(Intent(this, ResetPassword::class.java))}

            //richiamiamo la funzione login()
            login()

        }


    private fun createRequest() {
        //configurazione google sign-in attraverso una richiesta dell'ID utente, indirizzo e-mail e informazioni di base riguardanti il profilo utente
        //ID e informazioni di base riguardante il profilo utente sono inclusi in DEFAULT_SIGN_IN
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        //crea un GoogleSignInClient con le specifiche date da gso
        googleSignInClient = GoogleSignIn.getClient(this, gso)
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
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in avvenuto con successo
                    Log.d(TAG, "signInWithCredential:success")

                    val user = auth.currentUser
                } else {
                    // Sign in fallito
                    Log.w(TAG, "signInWithCredential:failure", task.exception)

                }

                //viene quindi lanciato un intent che ci porta all'activity vase
                val intent = Intent(this, Base::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(
                    this@MainActivity,
                    "Sign in con google effettuato con successo",
                    Toast.LENGTH_LONG
                ).show()
            }
            .addOnFailureListener(OnFailureListener {
                Log.d(TAG, "failure")
            })
    }

        /**
        * Al click del bottone che ci permette di fare l'accesso con google, viene lanciata la funzione signIn()
        *
         */
        override fun onClick(v: View?) {
         when (v!!.id) {
            R.id.bottone_gmail -> signIn()
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
                            val intent = Intent(this, Base::class.java)
                            startActivity(intent)
                            finish()
                            Toast.makeText(
                                this@MainActivity,
                                "Login effettuato con successo",
                                Toast.LENGTH_LONG
                            ).show()
                        }else{
                            //se le credenziali non sono inserite correttamente, appare un messaggio di errore
                            Toast.makeText(this@MainActivity, "Login fallito, email e/o password errati", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }

    /**
     * Questa funzione lancia un intent che ci permette di accedere all'area per utenti non registrati
     *
     */
    fun senzaReg(v: View) {
         val intent = Intent(this, Base_nonReg::class.java)
            startActivity(intent)
        Toast.makeText(
            this@MainActivity,
            "Sei entrato senza registrarti",
            Toast.LENGTH_LONG
        ).show()
    }

    /**
     * questa funzione lancia un intent che ci permette di accedere all'activity per effettuare la registrazione
     *
     */
    fun registratiView(v: View) {
        val intent2 = Intent(this, RegistrationActivity::class.java)
        startActivity(intent2)
    }


}