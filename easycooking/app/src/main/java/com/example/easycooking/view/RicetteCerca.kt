package com.example.easycooking.view

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
<<<<<<< HEAD
=======
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
>>>>>>> 6250dde975768a7ce92c5f570ea610e513292c4f
import com.example.easycooking.LoginActivity
import com.example.easycooking.R
import com.google.firebase.auth.FirebaseAuth
<<<<<<< HEAD
=======
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.toObject
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
>>>>>>> 6250dde975768a7ce92c5f570ea610e513292c4f


class RicetteCerca : Fragment(R.layout.fragment_ricettecerca) {
    val LOGIN_REQUEST = 101
    private var mAuth: FirebaseAuth? = null
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
>>>>>>> Stashed changes

    companion object {
>>>>>>> 6250dde975768a7ce92c5f570ea610e513292c4f

    companion object {
        fun newInstance(): RicetteTue {
            return RicetteTue()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_ricettecerca, container, false)
        return view
    }

<<<<<<< Updated upstream
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rv: RecyclerView? = view?.findViewById<RecyclerView>(R.id.rv)
=======
<<<<<<< HEAD


        /*override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
            super.onViewCreated(itemView, savedInstanceState)
        val rv: RecyclerView =findViewById(R.id.rv)
        rv.layoutManager = GridLayoutManager(this, 2)
=======
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rv: RecyclerView? = view?.findViewById<RecyclerView>(R.id.rv)
>>>>>>> 6250dde975768a7ce92c5f570ea610e513292c4f
>>>>>>> Stashed changes
        rv?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            // set the custom adapter to the RecyclerView

            //connessione al DB
            //creazione di un'istanza DB
            val myDB = FirebaseFirestore.getInstance()
            //connessione alla collection
            val ricettario = myDB.collection("cook")
            //creo la lista dove metterò le ricette
            var appoggio = mutableListOf<Ricetta>()
            //prendo le ricette e carico la lista
            ricettario.get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        var ricetta=document.toObject<Ricetta>()
                        appoggio.add(ricetta)
                    }
                }


            //FINE parte relativa allo scaricamento dei dati


            rv?.addItemDecoration(
                DefaultItemDecorator(
                    resources.getDimensionPixelSize(R.dimen.provider_name_horizontalBig_margin),
                    resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin)
                )
            )

            val alphaAdapter = AlphaInAnimationAdapter(RicettaAdapter(appoggio)).apply {
                // Change the durations.
                setDuration(500)
                // Disable the first scroll mode.
                setFirstOnly(false)
            }
            rv?.adapter = ScaleInAnimationAdapter(alphaAdapter).apply {
                setDuration(250)
            }
        }

            /*fun login(v: View) {
        val preferences = getSharedPreferences("login", Context.MODE_PRIVATE)
        if (preferences.getBoolean("firstrun", true)) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, LOGIN_REQUEST)
        } else {
            mAuth = FirebaseAuth.getInstance()
            val currentUser = mAuth!!.getCurrentUser()
            supportActionBar!!.setTitle(currentUser.displayName)
        }
    } */

<<<<<<< Updated upstream
=======
<<<<<<< HEAD

}
=======
>>>>>>> Stashed changes
            /* override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == LOGIN_REQUEST) {
            if (resultCode == RESULT_OK) {
                val nome = intent?.extras!!.getString("nome")
                val cognome = intent.extras!!.getString("cognome")
                supportActionBar!!.title = "$nome $cognome"
                val preferences = getSharedPreferences("login", MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putBoolean("firstrun", false)
                editor.apply()
            }
        }*/
        }
    }
<<<<<<< Updated upstream
=======
>>>>>>> 6250dde975768a7ce92c5f570ea610e513292c4f
>>>>>>> Stashed changes

