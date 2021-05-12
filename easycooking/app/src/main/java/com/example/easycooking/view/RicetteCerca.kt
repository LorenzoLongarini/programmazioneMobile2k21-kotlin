package com.example.easycooking.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.LoginActivity
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.dispensa.Dispensa
import com.example.easycooking.adapter.ricetta.Ingrediente
import com.example.easycooking.adapter.ricetta.Ricetta
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter


class RicetteCerca : Fragment(R.layout.fragment_ricettecerca) {
    val LOGIN_REQUEST = 101
    private var mAuth: FirebaseAuth? = null

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

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rv: RecyclerView? = view?.findViewById<RecyclerView>(R.id.rv)
        rv?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            // set the custom adapter to the RecyclerView
            /*var ing= Ingrediente("a","b","c")
            var ing1= Ingrediente("d","e","f")
            var ingr=arrayOf<Ingrediente>(ing,ing1)
            var listavuota= listOf<String>("","")

            var Dis1= Ricetta("Baci di dama","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis2= Ricetta("pavesini","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis3= Ricetta("Polpettone","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis11= Ricetta("Ghiacciolo","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis12= Ricetta("Spinaci","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis13= Ricetta("pennette","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis111= Ricetta("Baci di dama","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis112= Ricetta("pavesini","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis113= Ricetta("Polpettone","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis1111= Ricetta("Ghiacciolo","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis1112= Ricetta("Spinaci","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")
            var Dis1113= Ricetta("pennette","bacididama.jpg","","","","", listavuota,"","", listavuota,false,0,ingr.toList(),"")


            var appoggio=mutableListOf<Ricetta>(Dis1,Dis2,Dis3,Dis11,Dis12,Dis13,Dis111,Dis112,Dis113,Dis1111,Dis1112,Dis1113)

            //connessione al DB
            //creazione di un'istanza DB
            val myDB = FirebaseFirestore.getInstance()
            //connessione alla collection
            val ricettario = myDB.collection("cook")
            //creo la lista dove metterò le ricette
            var appoggio = mutableListOf<QueryDocumentSnapshot>()
            //prendo le ricette e carico la lista
            ricettario.get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        appoggio.add(document)
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
        }*/

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
    }}

