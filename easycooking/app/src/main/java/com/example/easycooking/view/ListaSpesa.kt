package com.example.easycooking.view
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.memory.dispensa.DispensaApplication
import com.example.easycooking.memory.spesa.SpesaDBEntity
import com.example.easycooking.R
import com.example.easycooking.memory.dispensa.DefaultItemDecorator
import com.example.easycooking.memory.spesa.*
import com.example.easycooking.utils.SwipeToDelete
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class ListaSpesa : Fragment(R.layout.fragment_listaspesa) {

    private val newSpesaActivityRequestCode = 1
    private val spesaViewModel: SpesaViewModel by viewModels {
        SpesaViewModelFactory((this.activity?.application as DispensaApplication).repositorySpesa)
    }

    companion object {

        fun newInstance(): ListaSpesa {
            return ListaSpesa()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_listaspesa, container, false)
        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Lista della spesa"
        val bt = view?.findViewById<Button>(R.id.compra)

        val rv = view?.findViewById<RecyclerView>(R.id.recspesa)
        val adapter = SpesaListAdapter()

        val alphaAdapter = AlphaInAnimationAdapter(adapter).apply {
            // Change the durations.
            setDuration(750)
            // Disable the first scroll mode.
            setFirstOnly(false)}


        rv?.adapter = ScaleInAnimationAdapter(alphaAdapter).apply {
            // Change the durations.
            setDuration(350)
            // Disable the first scroll mode.
            setFirstOnly(true)
        }
        rv?.addItemDecoration(
            DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.provider_name_horizontal_margin),
            resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin))
        )
        rv?.layoutManager = LinearLayoutManager(activity)


        //viene qui istanziata la classe SwipeToDelete, che consente di eliminare il prodotto
        //dalla lista della spesa
        val item  = object : SwipeToDelete(requireActivity(),0, ItemTouchHelper.LEFT){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //adapter.del(viewHolder.absoluteAdapterPosition)
                //dispensaViewModel.delete(dispensa)
                var spe=spesaViewModel.allprod.value
                var specanc= spe?.get(viewHolder.bindingAdapterPosition)
                adapter.elems.remove(this)
                if (specanc != null) {
                    spesaViewModel.delete(specanc)
                }
            }
        }

        val itemTouchHelper = ItemTouchHelper(item)
        itemTouchHelper.attachToRecyclerView(rv)

        activity?.let {
            spesaViewModel.allprod.observe(it) { prods ->
                // Update the cached copy of the words in the adapter.
                prods.let { adapter.submitList(it) }

                //al click sul bottone Compra, viene lanciata una nuova activity per inserire
                //il prodotto da acquistare
                bt?.setOnClickListener {
                    val intent = Intent(activity, Activity_compra::class.java)
                    startActivityForResult(intent, newSpesaActivityRequestCode)
                }
            }
        }
    }

    //nell'OnActivityResult andiamo a controllare se il prodotto viene inserito correttamente o meno
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newSpesaActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(Activity_compra.EXTRAs_REPLY)?.let { reply ->
                //se l'ingrediente è inserito correttamente, viene salvato nel database locale
                val spesa = SpesaDBEntity(reply)
                spesaViewModel.insert(spesa)
            }
        } else {
            //se l'ingrediente non è inserito correttamente, l'ingrediente non viene salvato
            Toast.makeText(
                context,
                "Non hai inserito un prodotto",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
