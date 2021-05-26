package com.example.easycooking.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.ricetta.Ricetta
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import com.example.easycooking.adapter.ricetta.SingolaRicetta
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_ricettecerca.*
import java.util.ArrayList


class RicetteCerca : Fragment(R.layout.fragment_ricettecerca) {
    val LOGIN_REQUEST = 101
    private var mAuth: FirebaseAuth? = null
    private lateinit var dbref: DatabaseReference
    private lateinit var recView: RecyclerView
    private lateinit var ricettaArray: ArrayList<Ricetta>
    private lateinit var search: EditText
    val btn: Button? =view?.findViewById<Button>(R.id.bottone_ricerca)
    val cate:Spinner?=view?.findViewById<Spinner>(R.id.categoria_ricerca)
    val orig:Spinner?=view?.findViewById<Spinner>(R.id.origine_ricerca)

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


    /*override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
    }*/

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        //val rv: RecyclerView? = view?.findViewById<RecyclerView>(R.id.rv)
        //rv?.layoutManager = LinearLayoutManager(activity)
        //rv?.setHasFixedSize(true)

        recView = view?.findViewById<RecyclerView>(R.id.rv)!!
        recView.layoutManager = LinearLayoutManager(activity)
        recView.setHasFixedSize(true)
        recView?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            // set the custom adapter to the RecyclerView
        }
        var origin="-----"
        var categ="-----"

        


        //var appoggio = mutableListOf<Ricetta>()
        ricettaArray = arrayListOf<Ricetta>()
        getRicetteFiltrate(origin,categ)
        /*val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val docRef = db.collection("cook").document("100")
        docRef.get().addOnSuccessListener { document ->
            val ric = document.toObject<Ricetta>()
            if (ric != null) {
                appoggio.add(0,ric)
            }
        }
        var o = mutableListOf<String>("k", "k")
        val ric1 =
            Ricetta(o, "k", "k", 0, "k", o, o, "k", "0", "k", "k", o, "k", "k", "k", o, false)
        appoggio.add(ric1)
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
        }*/



    }

    fun getRicette() {
        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (ricetteSnapshot in snapshot.children) {
                        val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                        ricettaArray.add(ricetta!!)

                    }
                    recView.adapter = context?.let { RicettaAdapter(ricettaArray, it) }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


    }
    fun getRicetteFiltrate(origin:String,categ:String) {

        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (ricetteSnapshot in snapshot.children) {
                        val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                        if ((origin!="-----")&&(categ!="-----")){
                        if ((ricetta?.recipeCategory==categ) && (ricetta?.recipeCuisine==origin)){
                        ricettaArray.add(ricetta!!)}}
                        else if (origin!="-----"){
                            if (ricetta?.recipeCuisine==origin){
                                ricettaArray.add(ricetta!!)}
                        }
                        else if (categ!="-----"){
                            if (ricetta?.recipeCategory==categ){
                                ricettaArray.add(ricetta!!)}
                        } else{
                            ricettaArray.add(ricetta!!)
                        }

                    }

                    recView.adapter = context?.let { RicettaAdapter(ricettaArray, it) }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


    }
    /*fun onItemClick(ricetta: Ricetta){
       val fragment: Fragment = SingolaRicetta.newInstance(SingolaRicetta)
       val transaction = activity?.supportFragmentManager!!.beginTransaction()
       activity?.supportFragmentManager!!.findFragmentByTag("Singola Ricetta")?.let {
           transaction.hide(
               it
           )
       }
       transaction.add(R.id.fragment_container_view_tag, fragment)
       transaction.addToBackStack(null)
       transaction.commit()
   }*/



}



/*override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
    super.onViewCreated(itemView, savedInstanceState)
val rv: RecyclerView =findViewById(R.id.rv)
rv.layoutManager = GridLayoutManager(this, 2)
 */

/*
override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
super.onViewCreated(itemView, savedInstanceState)
val rv: RecyclerView? = view?.findViewById<RecyclerView>(R.id.rv)
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
}
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
}*/

/*fun filtri(origine:String, categoria:String,lista:ArrayList<Ricetta>):ArrayList<Ricetta> {
     var risultato= arrayListOf<Ricetta>()
    if ((origine == "-----")&&(categoria == "-----")){
        risultato=lista
    } else if (origine=="-----"){

        for(ric in lista){
            if (ric.recipeCategory==categoria){
                risultato.add(ric)
            }
        }
    }else if (categoria=="-----"){

        for(ric in lista){
            if (ric.recipeCuisine==origine){
                risultato.add(ric)
            }
        }
    }else {

        for(ric in lista){
            if ((ric.recipeCuisine==origine)&&(ric.recipeCategory==categoria)){
                risultato.add(ric)
            }
        }
    }
    return risultato
}*/