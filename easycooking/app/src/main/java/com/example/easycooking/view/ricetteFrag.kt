package com.example.easycooking.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.dispensa.Dispensa
import com.example.easycooking.adapter.ricetta.Ingrediente
import com.example.easycooking.adapter.ricetta.Ricetta
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

//classe di prova fatta da Margherita
class ricettaFrag: Fragment() {
    companion object {

        fun newInstance(): ricettaFrag {
            return ricettaFrag()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_main, container, false)
        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rv: RecyclerView? = view?.findViewById<RecyclerView>(R.id.rv)
        rv?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity,2)
            // set the custom adapter to the RecyclerView

            //connessione al DB
            //creazione di un'istanza DB
            val myDB = FirebaseFirestore.getInstance ()
            //connessione alla collection
            val ricettario=myDB.collection("cook")
            //creo la lista dove metterò le ricette
            var appoggio= mutableListOf<Ricetta>()
            //prendo le ricette e carico la lista
            ricettario.get()
                .addOnSuccessListener {documents ->
                    for(document in documents){
                        var Ricetta=document.toObject(Ricetta::class.java)
                        appoggio.add(Ricetta)
                    }
                }
            //FINE parte relativa allo scaricamento dei dati


            rv?.addItemDecoration(
                DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.provider_name_horizontalBig_margin),
                resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin))
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
    }
}