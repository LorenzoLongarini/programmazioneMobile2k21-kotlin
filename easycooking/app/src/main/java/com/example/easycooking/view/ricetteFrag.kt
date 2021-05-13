/*package com.example.easycooking.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.ricetta.Ricetta
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import com.google.firebase.firestore.FirebaseFirestore
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import com.google.firebase.firestore.ktx.toObject

//classe di prova fatta da Margherita
class ricettaFrag: Fragment() {
    companion object {

        fun newInstance(): ricettaFrag {
            return ricettaFrag()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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

            var appoggio= mutableListOf<Ricetta>()

            val db:FirebaseFirestore=FirebaseFirestore.getInstance()
            val docRef = db.collection("cook").document("100")
            docRef.get().addOnSuccessListener { documentSnapshot ->
                val ric = documentSnapshot.toObject<Ricetta>()
                if (ric != null) {
                    appoggio.add(ric)
                }}
            var o= mutableListOf<String>("k","k")
            val ric1=Ricetta(o,"k","k",0,"k",o,o,"k","0","k","k",o,"k","k","k",o,false)
            appoggio.add(ric1)


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

}*/