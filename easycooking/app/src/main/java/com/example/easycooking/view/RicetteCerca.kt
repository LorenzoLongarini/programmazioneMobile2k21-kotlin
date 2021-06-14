package com.example.easycooking.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.memory.ricetta.Ricetta
import com.example.easycooking.memory.ricetta.RicettaAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*

/**
 * Questa classe ci permette di visualizzare tutte le ricette presenti
 */


class RicetteCerca : Fragment(R.layout.fragment_ricettecerca), AdapterView.OnItemSelectedListener {
    private var mAuth: FirebaseAuth? = null
    private lateinit var dbref: DatabaseReference
    private lateinit var recView: RecyclerView
    private lateinit var ricettaArray: ArrayList<Ricetta>

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

        recView = view?.findViewById<RecyclerView>(R.id.rv)!!
        recView.layoutManager = LinearLayoutManager(activity)
        recView.setHasFixedSize(true)
        recView?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            // set the custom adapter to the RecyclerView
        }
        var origin = "-----"
        var categ = "-----"
        var nome_ricetta = ""

        val cate: Spinner? = view?.findViewById<Spinner>(R.id.categoria_ricerca) as Spinner
        val orig: Spinner? = view?.findViewById<Spinner>(R.id.origine_ricerca)
        val btn: Button? = view?.findViewById<Button>(R.id.bottone_ricerca) as Button

        val nome = view?.findViewById<EditText>(R.id.nome_ricerca)


        // Spinner click listener
        cate?.onItemSelectedListener = this
        orig?.onItemSelectedListener = this

        // Spinner Drop down elements
        val categories: MutableList<String> = ArrayList()
        categories
        categories.add("-----")
        categories.add("Dolci")
        categories.add("Bevande & Cocktail")
        categories.add("Pane & Pizza")
        categories.add("Ricette base")
        categories.add("Marmellate & Conserve")
        categories.add("Secondi Piatti")
        categories.add("Primi")

        val origini: MutableList<String> = ArrayList()
        origini
        origini.add("-----")
        origini.add("Italiana")
        origini.add("Indiana")
        origini.add("Americana")
        origini.add("Cinese")
        origini.add("Francese")
        origini.add("Spagnola")
        origini.add("Giapponese")
        origini.add("Austriaca")
        origini.add("Marocchina")
        origini.add("Australiana")
        origini.add("Hawaiiana")
        origini.add("Brasiliana")
        origini.add("Cubana")
        origini.add("Inglese")
        origini.add("Messicana")
        origini.add("Polinesiana")
        origini.add("Portoricana")
        origini.add("Singaporiana")
        origini.add("Turca")
        origini.add("Tedesca")
        origini.add("Tunisina")
        origini.add("Greca")
        origini.add("Ungherese")
        origini.add("Svedese")
        origini.add("Africana")
        origini.add("SriLanka")
        origini.add("Taiwan")
        origini.add("Thailandese")


        // Creating adapter for spinner
        val dataAdapter =
            this.context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, categories) }
        val dataAdapter2 =
            this.context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, origini) }


        // Drop down layout style - list view with radio button
        dataAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dataAdapter2?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // attaching data adapter to spinner
        cate?.adapter = dataAdapter
        orig?.adapter = dataAdapter2

        //al click sul bottore Cerca, vengono visualizzate tutte le ricette che rispettano i filtraggi
        btn?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                btn?.text = "cerca"
                categ = cate?.selectedItem.toString()
                origin = orig?.selectedItem.toString()
                nome_ricetta = nome?.text.toString()
                ricettaArray = arrayListOf<Ricetta>()
                getRicetteFiltrate(origin, categ, nome_ricetta)
            }
        })
        (activity as AppCompatActivity).supportActionBar?.title = "Ricette"

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        // On selecting a spinner item
        val item = parent.getItemAtPosition(position).toString()

        // Showing selected spinner item
        if (item != "-----") {
            Toast.makeText(parent.context, "Hai selezionato: $item", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    /**
     * questa funzione ci permette di effettuare i vari filtraggi
     * riguardanti la categoria, l'origine del piatto e il nome della ricetta,
     * che vengono applicati alle ricette presenti nel Firebase Database
     */
    fun getRicetteFiltrate(origin: String, categ: String, nomeRic: String) {

        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (ricetteSnapshot in snapshot.children) {
                        val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                        if (ricetta?.nome!!.toLowerCase().contains(nomeRic.toLowerCase())) {
                            if ((origin != "-----") && (categ != "-----")) {
                                if ((ricetta?.recipeCategory == categ) && (ricetta?.recipeCuisine == origin)) {
                                    ricettaArray.add(ricetta!!)
                                }
                            } else if (origin != "-----") {
                                if (ricetta?.recipeCuisine == origin) {
                                    ricettaArray.add(ricetta!!)
                                }
                            } else if (categ != "-----") {
                                if (ricetta?.recipeCategory == categ) {
                                    ricettaArray.add(ricetta!!)
                                }
                            } else {
                                ricettaArray.add(ricetta!!)
                            }

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
}