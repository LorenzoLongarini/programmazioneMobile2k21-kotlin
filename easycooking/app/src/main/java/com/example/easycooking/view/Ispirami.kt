package com.example.easycooking.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.example.easycooking.memory.ricetta.Ricetta
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

/**
 * Questa classe è utilizzata per applicare la funzione Ispirami.
 * Viene estratta una ricetta random dal database e visualizzata nel fragment
 */

class Ispirami : Fragment() {


    private lateinit var dbref: DatabaseReference
    private lateinit var condividi: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.ispirami, container, false)
        return view
    }

    companion object {
        fun newInstance(): Ispirami {
            return Ispirami()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Ispirami"

        val titolo: TextView = view?.findViewById<TextView>(R.id.immagine_ricetta_vista)
        val prepTime: TextView = view?.findViewById<TextView>(R.id.tempo_preparazione)
        val cookTime: TextView = view?.findViewById<TextView>(R.id.tempo_cottura)
        val totTime: TextView = view?.findViewById<TextView>(R.id.tempo_totale)
        val cat: TextView = view?.findViewById<TextView>(R.id.categoria)
        val orig: TextView = view?.findViewById<TextView>(R.id.origine)
        val intoll: TextView = view?.findViewById<TextView>(R.id.intolleranze)
        val veg: TextView = view?.findViewById<TextView>(R.id.vegano)
        val ingr: TextView = view?.findViewById<TextView>(R.id.Ingredienti)
        val quant: TextView = view?.findViewById<TextView>(R.id.Quantità)
        val unit: TextView = view?.findViewById<TextView>(R.id.Unitàdimisura)
        val prep: TextView = view?.findViewById<TextView>(R.id.procedimento_vista)
        val photo: ImageView = view?.findViewById<ImageView>(R.id.photo)
        val ispirami: Button=view?.findViewById<Button>(R.id.random_button)

        //vengono scaricate le ricette da firebase e inserite in un array
        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.get().addOnSuccessListener {
            var ricettaArray= arrayListOf<Ricetta>()
            for (ricetteSnapshot in it.children) {
                val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                ricettaArray.add(ricetta!!)
            }
            //di tutte le ricette, ne viene presa una random e i campi del fragment
            //vengono riempiti con i campi della ricetta estratta
            var ricettina = ricettaArray.random()
            titolo.text = ricettina?.nome
            prepTime.text = ricettina?.prepTime
            cookTime.text = ricettina?.cookTime
            totTime.text = ricettina?.totalTime
            cat.text = ricettina?.recipeCategory
            orig.text = ricettina?.recipeCuisine

            var arrayIntoll = ricettina.intolleranze
            var intoller = ""
            if (arrayIntoll != null) {
                for (intol in arrayIntoll) {
                    intoller += intol
                }
            } else {
                intoller = "nessuna intolleranza"
            }
            var arrayIngr = ricettina.Ingredienti
            var ingred = ""
            if (arrayIngr != null) {
                for (ing in arrayIngr) {
                    ingred = ingred + ing + "\n"
                }
            }
            var arrayQuant = ricettina.quantita
            var quantit = ""
            if (arrayQuant != null) {
                for (ing in arrayQuant) {
                    quantit = quantit + ing + "\n"
                }
            } else {
                quantit = "null"
            }
            var arrayUnit = ricettina.unita
            var unita = ""
            if (arrayUnit != null) {
                for (ing in arrayUnit) {
                    unita = unita + ing + "\n"
                }
            }
            var veggy = ricettina.vegano
            var vegano = "No"
            if (veggy == true) {
                vegano = "Si"
            }

            intoll.text = intoller
            veg.text = vegano
            ingr.text = ingred
            quant.text = quantit
            unit.text = unita
            prep.text = ricettina?.preparazione

            val storage = Firebase.storage
            var image = ricettina.image
            val n_image = "images/".plus(image)
            val imagereference = storage.reference.child(n_image)
            imagereference.downloadUrl.addOnSuccessListener { uri ->
                Glide.with(this)
                    .load(uri)
                    //.fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL) //ALL or NONE as your requirement
                    .into(photo)
            }.addOnFailureListener { // Handle any errors
                Glide.with(this)
                    .load(R.drawable.coltforc)
                    //.fitCenter()
                    .into(photo)
            }

            condividi = view?.findViewById(R.id.button_share1)

            //viene settato il bottone di condivisione
            condividi.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val shareSub = "Scarica EasyCooking"
                val shareBody = "Scarica la app EasyCooking per scoprire tante ricette come "+(titolo.text as String?)
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
                intent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(intent, "Vieni a visitare la app EasyCooking"))
            }

            //al click sul pulsante Ispirami!, viene estratta un'altra ricetta random
            //i campi del fragment vengono aggiornati con i campi della nuova ricetta
            ispirami.setOnClickListener {
                ricettina=ricettaArray.random()
                titolo.text = ricettina?.nome
                prepTime.text = ricettina?.prepTime
                cookTime.text = ricettina?.cookTime
                totTime.text = ricettina?.totalTime
                cat.text = ricettina?.recipeCategory
                orig.text = ricettina?.recipeCuisine

                var arrayIntoll = ricettina.intolleranze
                var intoller = ""
                if (arrayIntoll != null) {
                    for (intol in arrayIntoll) {
                        intoller += intol
                    }
                } else {
                    intoller = "nessuna intolleranza"
                }
                var arrayIngr = ricettina.Ingredienti
                var ingred = ""
                if (arrayIngr != null) {
                    for (ing in arrayIngr) {
                        ingred = ingred + ing + "\n"
                    }
                }
                var arrayQuant = ricettina.quantita
                var quantit = ""
                if (arrayQuant != null) {
                    for (ing in arrayQuant) {
                        quantit = quantit + ing + "\n"
                    }
                } else {
                    quantit = "null"
                }
                var arrayUnit = ricettina.unita
                var unita = ""
                if (arrayUnit != null) {
                    for (ing in arrayUnit) {
                        unita = unita + ing + "\n"
                    }
                }
                var veggy = ricettina.vegano
                var vegano = "No"
                if (veggy == true) {
                    vegano = "Si"
                }

                intoll.text = intoller
                veg.text = vegano
                ingr.text = ingred
                quant.text = quantit
                unit.text = unita
                prep.text = ricettina?.preparazione


                val storage = Firebase.storage
                var image = ricettina.image
                val n_image = "images/".plus(image)
                val imagereference = storage.reference.child(n_image)
                imagereference.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(this)
                        .load(uri)
                        //.fitCenter()
                        .diskCacheStrategy(DiskCacheStrategy.ALL) //ALL or NONE as your requirement
                        .into(photo)
                }.addOnFailureListener { // Handle any errors
                    Glide.with(this)
                        .load(R.drawable.coltforc)
                        //.fitCenter()
                        .into(photo)
                }
            }
        }
    }
}

