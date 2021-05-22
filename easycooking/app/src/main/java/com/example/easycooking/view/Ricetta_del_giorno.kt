package com.example.easycooking.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.example.easycooking.adapter.ricetta.Ricetta
import com.firebase.ui.auth.AuthUI.getApplicationContext
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.ispirami.*
import java.text.SimpleDateFormat
import java.util.*


class Ricetta_del_giorno : Fragment() {


    private lateinit var dbref: DatabaseReference
   val c:Calendar= Calendar.getInstance()
    val df:SimpleDateFormat= SimpleDateFormat("dd-MMM-yyyy")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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


            var ricettina = ricettaArray[0]
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

            var dataOdierna:String=df.format(c.time)
            var dataVisita:String = df.format(c.time)
            loadDate(dataVisita)
            saveDate(dataVisita)
            if (!(dataVisita.equals(dataOdierna))){


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




                saveDate(dataVisita)

            }




        }

    }
    fun saveDate(dataVisita:String) {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("MY_PREFS_DATE", Context.MODE_PRIVATE)
        val editor = prefs?.edit()
        editor?.putString("date", dataVisita)
        editor?.apply()
    }

    fun loadDate(dataVisita:String) {
        var prefs: SharedPreferences? =
            context?.getSharedPreferences("MY_PREFS_DATE", Context.MODE_PRIVATE)
        var dataVisita = prefs?.getString("date", "default value").toString()
    }


}