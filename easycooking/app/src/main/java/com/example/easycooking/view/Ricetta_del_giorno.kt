package com.example.easycooking.view

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.example.easycooking.adapter.ricetta.Ricetta
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.*

/*
class Ricetta_del_giorno : Fragment() {


    private lateinit var dbref: DatabaseReference


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

    @RequiresApi(Build.VERSION_CODES.P)
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
            var ricettaArray = arrayListOf<Ricetta>()
            for (ricetteSnapshot in it.children) {
                val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                ricettaArray.add(ricetta!!)
            }
/*
            val handler = Handler()
            val runnableCode = Runnable { // Do something here on the main thread
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

            handler.postDelayed( runnableCode,3, 0)

 */

            val h = Handler()
            h.postDelayed(object : Runnable {
                private var time: Long = 0
                override fun run() {
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
                        context?.let { it1 ->
                            Glide.with(it1)
                                .load(uri)
                                //.fitCenter()
                                .diskCacheStrategy(DiskCacheStrategy.ALL) //ALL or NONE as your requirement
                                .into(photo)
                        }
                    }.addOnFailureListener { // Handle any errors
                        context?.let { it1 ->
                            Glide.with(it1)
                                .load(R.drawable.coltforc)
                                //.fitCenter()
                                .into(photo)
                        }
                    }
                    time += 1000
                    h.postDelayed(this, 86400)
                }
            }, 0) // 1 second delay (takes millis)
        }
    }
}*/

class Ricetta_del_giorno : AppCompatActivity() {


    private lateinit var dbref: DatabaseReference


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ricetta_del_giorno)


        val titolo: TextView = findViewById<TextView>(R.id.immagine_ricetta_vista)
        val prepTime: TextView = findViewById<TextView>(R.id.tempo_preparazione)
        val cookTime: TextView = findViewById<TextView>(R.id.tempo_cottura)
        val totTime: TextView = findViewById<TextView>(R.id.tempo_totale)
        val cat: TextView = findViewById<TextView>(R.id.categoria)
        val orig: TextView = findViewById<TextView>(R.id.origine)
        val intoll: TextView = findViewById<TextView>(R.id.intolleranze)
        val veg: TextView = findViewById<TextView>(R.id.vegano)
        val ingr: TextView = findViewById<TextView>(R.id.Ingredienti)
        val quant: TextView = findViewById<TextView>(R.id.Quantità)
        val unit: TextView = findViewById<TextView>(R.id.Unitàdimisura)
        val prep: TextView = findViewById<TextView>(R.id.procedimento_vista)
        val photo: ImageView = findViewById<ImageView>(R.id.photo)


        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.get().addOnSuccessListener {
            var ricettaArray = arrayListOf<Ricetta>()
            for (ricetteSnapshot in it.children) {
                val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                ricettaArray.add(ricetta!!)
            }

            val h = Handler()
                h.postDelayed(object : Runnable {
                    private var time: Long = 0
                    override fun run() {

                        var ricettina = ricettaArray.random()
                        var arrayIntoll=intent.getStringArrayExtra("Intoll")
                        var intoller=""
                        if (arrayIntoll != null) {
                            for (intol in arrayIntoll){
                                intoller += intol
                            }
                        }else{
                            intoller="nessuna intolleranza"
                        }
                        var arrayIngr=intent.getStringArrayExtra("Ingr")
                        var ingred=""
                        if (arrayIngr != null) {
                            for (ing in arrayIngr){
                                ingred=ingred+ing+"\n"
                            }
                        }
                        var arrayQuant=intent.getStringArrayExtra("Quant")
                        var quantit=""
                        if (arrayQuant != null) {
                            for (ing in arrayQuant){
                                quantit=quantit+ing+"\n"
                            }
                        }else{
                            quantit="null"
                        }
                        var arrayUnit=intent.getStringArrayExtra("Unit")
                        var unita=""
                        if (arrayUnit != null) {
                            for (ing in arrayUnit){
                                unita=unita+ing+"\n"
                            }
                        }
                        var veggy=intent.getBooleanExtra("Veg",false)
                        var vegano="No"
                        if (veggy){
                            vegano="Si"
                        }

                        val storage = Firebase.storage
                        var image=intent.getStringExtra("image")
                        val n_image = "images/".plus(image)
                        val imagereference = storage.reference.child(n_image)
                        imagereference.downloadUrl.addOnSuccessListener { uri ->
                            Glide.with(baseContext)
                                .load(uri)
                                //.fitCenter()
                                .diskCacheStrategy(DiskCacheStrategy.ALL) //ALL or NONE as your requirement
                                .into(photo)
                        }.addOnFailureListener { // Handle any errors
                            Glide.with(baseContext)
                                .load(R.drawable.coltforc)
                                //.fitCenter()
                                .into(photo)
                        }


                        titolo.text=intent.getStringExtra("Titolo")
                        prepTime.text=intent.getStringExtra("Prep")
                        cookTime.text=intent.getStringExtra("Cott")
                        totTime.text=intent.getStringExtra("Tot")
                        cat.text=intent.getStringExtra("Cat")
                        orig.text=intent.getStringExtra("Orig")
                        intoll.text=intoller
                        veg.text=vegano
                        ingr.text=ingred
                        quant.text=quantit
                        unit.text=unita
                        prep.text=intent.getStringExtra("Preparaz")
                        time += 1000
                        h.postDelayed(this, 86400)
                    }
        }, 0) // 1 second delay (takes millis)
        }
    }
}