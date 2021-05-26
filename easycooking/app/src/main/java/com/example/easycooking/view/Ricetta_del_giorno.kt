package com.example.easycooking.view

import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.easycooking.R
import com.example.easycooking.ViewModels.ricettaDelGiornoViewModel
import com.example.easycooking.adapter.ricetta.Ricetta
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import io.reactivex.Observer
import java.util.*
import kotlin.coroutines.coroutineContext
import kotlin.properties.Delegates


class Ricetta_del_giorno : Fragment() {


    private lateinit var dbref: DatabaseReference
    private var someStateValue by Delegates.notNull<Int>()
    private var VALUE_KEY: Int = 1
    private var fragmentSimple: Ricetta_del_giorno? = null
    private val SIMPLE_FRAGMENT_TAG = "ricetta_giorno"

    /*
    var titolo = view?.findViewById<TextView>(R.id.immagine_ricetta_vista)
    var prepTime = view?.findViewById<TextView>(R.id.tempo_preparazione)
    var cookTime = view?.findViewById<TextView>(R.id.tempo_cottura)
    var totTime = view?.findViewById<TextView>(R.id.tempo_totale)
    var cat = view?.findViewById<TextView>(R.id.categoria)
    var orig = view?.findViewById<TextView>(R.id.origine)
    var intoll = view?.findViewById<TextView>(R.id.intolleranze)
    var veg = view?.findViewById<TextView>(R.id.vegano)
    var ingr = view?.findViewById<TextView>(R.id.Ingredienti)
    var quant = view?.findViewById<TextView>(R.id.Quantità)
    var unit = view?.findViewById<TextView>(R.id.Unitàdimisura)
    var prep = view?.findViewById<TextView>(R.id.procedimento_vista)
    var photo = view?.findViewById<ImageView>(R.id.photo)
     */


    var titolo = ""
    var prepTime = ""
    var cookTime = ""
    var totTime = ""
    var cat = ""
    var orig = ""
    var intoll = ""
    var veg = ""
    var ingr = ""
    var quant = ""
    var unit = ""
    var prep = ""
    var photo = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        if (savedInstanceState != null) {
            someStateValue = savedInstanceState.getInt(VALUE_KEY.toString())
            // Do something with value if needed
        }

            if (savedInstanceState != null) { // saved instance state, fragment may exist
                // look up the instance that already exists by tag
                fragmentSimple =
                    fragmentManager?.findFragmentByTag(SIMPLE_FRAGMENT_TAG) as Ricetta_del_giorno?
            } else if (fragmentSimple == null) {
                // only create fragment if they haven't been instantiated already
                fragmentSimple = Ricetta_del_giorno()
            }*/

        val view: View =
            inflater.inflate(R.layout.fragment_ricetta_del_giorno, container, false)
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

        /*
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
         */

        titolo = view?.findViewById<TextView>(R.id.immagine_ricetta_vista).toString()
        prepTime = view?.findViewById<TextView>(R.id.tempo_preparazione).toString()
        cookTime = view?.findViewById<TextView>(R.id.tempo_cottura).toString()
        totTime = view?.findViewById<TextView>(R.id.tempo_totale).toString()
        cat = view?.findViewById<TextView>(R.id.categoria).toString()
        orig = view?.findViewById<TextView>(R.id.origine).toString()
        intoll = view?.findViewById<TextView>(R.id.intolleranze).toString()
        veg = view?.findViewById<TextView>(R.id.vegano).toString()
        ingr = view?.findViewById<TextView>(R.id.Ingredienti).toString()
        quant = view?.findViewById<TextView>(R.id.Quantità).toString()
        unit = view?.findViewById<TextView>(R.id.Unitàdimisura).toString()
        prep = view?.findViewById<TextView>(R.id.procedimento_vista).toString()

        val viewModel: ricettaDelGiornoViewModel by viewModels()
        viewModel.getRicette()
        })
        /*
                    titolo!!.text = savedInstanceState!!.getString("titolo") ?: ricettina?.nome
                    prepTime!!.text = savedInstanceState!!.getString("prepTime") ?: ricettina?.prepTime
                    cookTime!!.text = savedInstanceState!!.getString("cookTime") ?: ricettina?.cookTime
                    totTime!!.text = savedInstanceState!!.getString("totalTime") ?: ricettina?.totalTime
                    cat!!.text = savedInstanceState!!.getString("recipeCategory") ?: ricettina?.recipeCategory
                    orig!!.text = savedInstanceState!!.getString("recipeCuisine") ?: ricettina?.recipeCuisine
                    */


        titolo = savedInstanceState!!.getString("titolo") ?: ricettina.nome.toString()
        prepTime = savedInstanceState.getString("prepTime") ?: ricettina.prepTime.toString()
        cookTime = savedInstanceState.getString("cookTime") ?: ricettina.cookTime.toString()
        totTime = savedInstanceState.getString("totalTime") ?: ricettina.totalTime.toString()
        cat = savedInstanceState.getString("recipeCategory") ?: ricettina.recipeCategory.toString()
        orig = savedInstanceState.getString("recipeCuisine") ?: ricettina.recipeCuisine.toString()

        var arrayIntoll =
            savedInstanceState.getStringArrayList("intolleranze") ?: ricettina.intolleranze
        var intoller = ""
        if (arrayIntoll != null) {
            for (intol in arrayIntoll) {
                intoller += intol
            }
        } else {
            intoller = "nessuna intolleranza"
        }
        var arrayIngr =
            savedInstanceState.getStringArrayList("ingredienti") ?: ricettina.Ingredienti
        var ingred = ""
        if (arrayIngr != null) {
            for (ing in arrayIngr) {
                ingred = ingred + ing + "\n"
            }
        }
        var arrayQuant = savedInstanceState.getStringArrayList("quantita") ?: ricettina.quantita
        var quantit = ""
        if (arrayQuant != null) {
            for (ing in arrayQuant) {
                quantit = quantit + ing + "\n"
            }
        } else {
            quantit = "null"
        }
        var arrayUnit = savedInstanceState.getStringArrayList("unita") ?: ricettina.unita
        var unita = ""
        if (arrayUnit != null) {
            for (ing in arrayUnit) {
                unita = unita + ing + "\n"
            }
        }
        var veggy = savedInstanceState.getBoolean("vegano")
        var vegano = "No"
        if (veggy) {
            vegano = "Si"
        }


        /*intoll = savedInstanceState.getString("intoller") ?: intoller
        veg = savedInstanceState.getString("vegano") ?: vegano
        ingr = savedInstanceState.getString("ingred") ?: ingred
        quant = savedInstanceState.getString("quantit") ?: quantit
        unit = savedInstanceState.getString("unita") ?: unita
        prep = savedInstanceState.getString("preparazione") ?: ricettina?.preparazione.toString()*/

        /*
                    intoll!!.text = savedInstanceState.getString("intoller") ?: intoller
                    veg!!.text = savedInstanceState.getString("vegano") ?: vegano
                    ingr!!.text = savedInstanceState.getString("ingred") ?: ingred
                    quant!!.text = savedInstanceState.getString("quantit") ?:quantit
                    unit!!.text = savedInstanceState.getString("unita") ?: unita
                    prep!!.text = savedInstanceState.getString("preparazione") ?: ricettina?.preparazione.toString()
                    */
        /*
                    val storage = Firebase.storage
                    var image = savedInstanceState.getString("image") ?: ricettina.image
                    val n_image = "images/".plus(image)
                    val imagereference = storage.reference.child(n_image)
                    imagereference.downloadUrl.addOnSuccessListener { uri ->
                        Glide.with(th)
                            .load(uri)
                            //.fitCenter()
                            .diskCacheStrategy(DiskCacheStrategy.ALL) //ALL or NONE as your requirement
                            .into(photo)

                    }.addOnFailureListener { // Handle any errors
                        Glide.with()
                            .load(R.drawable.coltforc)
                            //.fitCenter()
                            .into(photo)

                    }*/

        view?.findViewById<TextView>(R.id.immagine_ricetta_vista).text = titolo.toString()
        view?.findViewById<TextView>(R.id.tempo_preparazione).text = prepTime.toString()
        view?.findViewById<TextView>(R.id.tempo_cottura).text = cookTime.toString()
        view?.findViewById<TextView>(R.id.tempo_totale).text = totTime.toString()
        view?.findViewById<TextView>(R.id.categoria).text = cat.toString()
        view?.findViewById<TextView>(R.id.origine).text = orig.toString()
        view?.findViewById<TextView>(R.id.intolleranze).text = intoll.toString()
        view?.findViewById<TextView>(R.id.vegano).text = veg.toString()
        view?.findViewById<TextView>(R.id.Ingredienti).text = ingr.toString()
        view?.findViewById<TextView>(R.id.Quantità).text = quant.toString()
        view?.findViewById<TextView>(R.id.Unitàdimisura).text = unit.toString()
        view?.findViewById<TextView>(R.id.procedimento_vista).text = prep.toString()

        /*
                    view?.findViewById<TextView>(R.id.immagine_ricetta_vista).text = titolo
                    view?.findViewById<TextView>(R.id.tempo_preparazione).text = prepTime
                    view?.findViewById<TextView>(R.id.tempo_cottura).text = cookTime
                    view?.findViewById<TextView>(R.id.tempo_totale).text = totTime
                    view?.findViewById<TextView>(R.id.categoria).text = cat
                    view?.findViewById<TextView>(R.id.origine).text = orig
                    view?.findViewById<TextView>(R.id.intolleranze).text = intoll
                    view?.findViewById<TextView>(R.id.vegano).text = veg
                    view?.findViewById<TextView>(R.id.Ingredienti).text = ingr
                    view?.findViewById<TextView>(R.id.Quantità).text = quant
                    view?.findViewById<TextView>(R.id.Unitàdimisura).text = unit
                    view?.findViewById<TextView>(R.id.procedimento_vista).text = prep*/


        //time += 1000
    }

    override fun onSaveInstanceState(outState: Bundle) {
       /*
        outState.putString("titolo", titolo)
        outState.putString("prepTime", prepTime)
        outState.putString("cookTime", cookTime)
        outState.putString("totTime", totTime)
        outState.putString("cat", cat)
        outState.putString("intoller", intoll)
        outState.putString("vegano", veg)
        outState.putString("ingred", ingr)
        outState.putString("quantit", quant)
        outState.putString("unita", unit)
        outState.putString("preparazione", prep)*/

        outState.putString("titolo", titolo.toString())
        outState.putString("prepTime", prepTime.toString())
        outState.putString("cookTime", cookTime.toString())
        outState.putString("totTime", totTime.toString())
        outState.putString("cat", cat.toString())
        outState.putString("intoller", intoll.toString())
        outState.putString("vegano", veg.toString())
        outState.putString("ingred", ingr.toString())
        outState.putString("quantit", quant.toString())
        outState.putString("unita", unit.toString())
        outState.putString("preparazione", prep.toString())

        super.onSaveInstanceState(outState)
    }


}

/*class Ricetta_del_giorno() : AppCompatActivity() {


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

            handler.postDelayed(runnableCode, 3, 0)


        }
    }


}



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
                    time += 1000
                    h.postDelayed(this, 20000)
                }
            }, 0) // 1 second delay (takes millis)
        }

    }


}*/