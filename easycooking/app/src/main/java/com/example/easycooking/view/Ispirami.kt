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

class Ispirami : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var ricettaArray: ArrayList<Ricetta>
    private lateinit var ricDay: Ricetta
    private lateinit var randomizer: Random
    private lateinit var nome: TextView
    private lateinit var immagine: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ispirami)

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

        ricettadelGiorno()

        var arrayIntoll = intent.getStringArrayExtra("Intoll")
        var intoller = ""
        if (arrayIntoll != null) {
            for (intol in arrayIntoll) {
                intoller += intol
            }
        } else {
            intoller = "nessuna intolleranza"
        }
        var arrayIngr = intent.getStringArrayExtra("Ingr")
        var ingred = ""
        if (arrayIngr != null) {
            for (ing in arrayIngr) {
                ingred = ingred + ing + "\n"
            }
        }
        var arrayQuant = intent.getStringArrayExtra("Quant")
        var quantit = ""
        if (arrayQuant != null) {
            for (ing in arrayQuant) {
                quantit = quantit + ing + "\n"
            }
        } else {
            quantit = "null"
        }
        var arrayUnit = intent.getStringArrayExtra("Unit")
        var unita = ""
        if (arrayUnit != null) {
            for (ing in arrayUnit) {
                unita = unita + ing + "\n"
            }
        }
        var veggy = intent.getBooleanExtra("Veg", false)
        var vegano = "No"
        if (veggy) {
            vegano = "Si"
        }

        val storage = Firebase.storage
        var image = intent.getStringExtra("image")
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


        titolo.text = intent.getStringExtra("Titolo")
        prepTime.text = intent.getStringExtra("Prep")
        cookTime.text = intent.getStringExtra("Cott")
        totTime.text = intent.getStringExtra("Tot")
        cat.text = intent.getStringExtra("Cat")
        orig.text = intent.getStringExtra("Orig")
        intoll.text = intoller
        veg.text = vegano
        ingr.text = ingred
        quant.text = quantit
        unit.text = unita
        prep.text = intent.getStringExtra("Preparaz")

        button.setOnClickListener { onClick(random_button) }
    }

    private fun onClick(v: View) {
        when (v!!.id) {
            R.id.random_button -> ricettadelGiorno()
        }
    }

    private fun ricettadelGiorno(): Ricetta {
        var ricettarray=getRicette()
        var ricDay= ricettarray.random()
        return ricDay
    }

    private fun getRicette(): ArrayList<Ricetta> {
        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val index = Random.nextInt(snapshot.childrenCount.toInt())
                    var count = 0
                if (snapshot.exists()) {
                    for (ricetteSnapshot in snapshot.children) {
                        if(count == index) {
                            val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                            ricettaArray.add(ricetta!!)
                            return
                        }
                    }
                  count++
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        return ricettaArray
    }

}

