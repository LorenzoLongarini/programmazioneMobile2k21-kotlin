package com.example.easycooking.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.example.easycooking.adapter.ricetta.Ricetta
import com.example.easycooking.adapter.ricetta.RicettaAdapter
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.ispirami.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class Ricetta_del_giorno : Fragment() {


    private lateinit var dbref: DatabaseReference
   //val c:Calendar


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.ricetta_del_giorno, container, false)
        return view
    }

    companion object {
        fun newInstance(): Ricetta_del_giorno {
            return Ricetta_del_giorno()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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
        

        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.get().addOnSuccessListener {
            var ricettaArray= arrayListOf<Ricetta>()
            for (ricetteSnapshot in it.children) {
                val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                ricettaArray.add(ricetta!!)
            }


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

        }

    }}