package com.example.easycooking.spesa
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.DB.DispensaApplication
import com.example.easycooking.DB.DispensaViewModel
import com.example.easycooking.spesa.SpesaDBEntity
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.spesa.*
import com.example.easycooking.view.Activity_ricetta
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class ListaSpesaDispensa :  AppCompatActivity() {

    private val newSpesaActivityRequestCode = 1
    private val spesaViewModel: SpesaViewModel by viewModels {
        SpesaViewModelFactory((this.application as DispensaApplication).repositorySpesa)
    }
    private val dispensaViewModel: DispensaViewModel by viewModels {
        DispensaViewModel.DispensaViewModelFactory((this.application as DispensaApplication).repositoryDispensa)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compradis)



        var nome=intent.getStringExtra("Titolo")
        var prepTime=intent.getStringExtra("Prep")
        var cookTime=intent.getStringExtra("Cott")
        var totalTime=intent.getStringExtra("Tot")
        var recipeCategory=intent.getStringExtra("Cat")
        var recipeCuisine=intent.getStringExtra("Orig")
        var intolleranze=intent.getStringArrayExtra("Intoll")
        var vegano=intent.getBooleanExtra("Veg",false)
        var Ingredienti=intent.getStringArrayExtra("Ingr")
        var quantita=intent.getStringArrayExtra("Quant")
        var unita=intent.getStringArrayExtra("Unit")
        var preparazione =intent.getStringExtra("Preparaz")
        var image=intent.getStringExtra("image")
        var disp=intent.getStringArrayExtra("Disp")


        var arrayDis=disp
        var manc= arrayListOf<String>()



        if (manc != null) {
            if (Ingredienti != null) {
                for (ma in Ingredienti){
                    if (arrayDis != null) {
                        if(!arrayDis.contains(ma.toLowerCase())){
                            manc.add(ma)
                        }

                    }
                }
            }
        }

        var mancanti=""
        if (manc != null) {
            for (ma in manc){
                mancanti=mancanti+ma+"\n"
            }
        }

        var displaymancanti=findViewById<TextView>(R.id.textView21)
        var agg=findViewById<Button>(R.id.button2)
        var ignora=findViewById<Button>(R.id.button3)
        displaymancanti.text=mancanti

        agg.setOnClickListener {
            if (manc != null) {
                for (ma in manc) {
                    var spe = SpesaDBEntity(ma)
                    spesaViewModel.insert(spe)
                }
            }
            val intent= Intent(applicationContext, Activity_ricetta::class.java)
            intent.putExtra("Titolo", nome)
            intent.putExtra("Prep",prepTime)
            intent.putExtra("Cott",cookTime)
            intent.putExtra("Tot",totalTime)
            intent.putExtra("Cat",recipeCategory)
            intent.putExtra("Orig",recipeCuisine)
            intent.putExtra("Intoll", intolleranze)
            intent.putExtra("Veg", vegano)
            intent.putExtra("Ingr",Ingredienti)
            intent.putExtra("Quant",quantita)
            intent.putExtra("Unit",unita)
            intent.putExtra("Preparaz",preparazione)
            intent.putExtra("image",image)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //la visualizzazione della ricetta avviene dopo il click sulla singola card della ricetta filtrata
            applicationContext.startActivity(intent)

        }
        ignora.setOnClickListener {
            val intent= Intent(applicationContext, Activity_ricetta::class.java)
            intent.putExtra("Titolo", nome)
            intent.putExtra("Prep",prepTime)
            intent.putExtra("Cott",cookTime)
            intent.putExtra("Tot",totalTime)
            intent.putExtra("Cat",recipeCategory)
            intent.putExtra("Orig",recipeCuisine)
            intent.putExtra("Intoll", intolleranze)
            intent.putExtra("Veg", vegano)
            intent.putExtra("Ingr",Ingredienti)
            intent.putExtra("Quant",quantita)
            intent.putExtra("Unit",unita)
            intent.putExtra("Preparaz",preparazione)
            intent.putExtra("image",image)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            //la visualizzazione della ricetta avviene dopo il click sulla singola card della ricetta filtrata
            applicationContext.startActivity(intent)
        }
        }

    }










