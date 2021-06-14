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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.easycooking.R
import com.example.easycooking.memory.dispensa.*
import com.example.easycooking.memory.ricetta.Ricetta
import com.example.easycooking.memory.ricettaTua.RicettaAdapterDispensa

import com.example.easycooking.memory.dispensa.Activity_inserisci_dispensa
import com.example.easycooking.utils.SwipeToDelete
import com.google.firebase.database.*
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import java.util.ArrayList


class dispensaFrag: Fragment(R.layout.fragment_dispensa) {


    private val newDispensaActivityRequestCode = 1
    private lateinit var dbref: DatabaseReference
    private lateinit var recView: RecyclerView
    private lateinit var ricettaArray: ArrayList<Ricetta>
    private val dispensaViewModel: DispensaViewModel by viewModels {
        DispensaViewModel.DispensaViewModelFactory((activity?.application as DispensaApplication).repositoryDispensa)
    }
    val adapter = DispensaListAdapter()

    companion object {

        fun newInstance(): dispensaFrag {
            return dispensaFrag()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dispensa, container, false)
        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val bt = view?.findViewById<Button>(R.id.bt)
        val bt_cerca = view?.findViewById<Button>(R.id.bt_cerca)
        val rv = view?.findViewById<RecyclerView>(R.id.rv)

        recView = view?.findViewById<RecyclerView>(R.id.rv1)!!
        recView.layoutManager = LinearLayoutManager(activity)
        recView.setHasFixedSize(true)
        recView?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity, 2)
            // set the custom adapter to the RecyclerView
        }

        //con il click sul bottone cerca, viene applicato un filtro su tutte le ricertte
        // che contengono gli ingredienti presenti in dispensa
        bt_cerca?.setOnClickListener( object : View.OnClickListener{
            override fun onClick(v: View?) {
                var ingr= mutableListOf<String>()
                var ingred=dispensaViewModel.allprod.value
                if (ingred != null) {
                    for (k in ingred){
                        ingr.add(k.nomeProdotto)
                    }
                        ricettaArray = arrayListOf<Ricetta>()
                }
                //viene richiamata la funzione per filtrare le ricette
                //in base ai prodotti presenti in dispensa
                getRicetteFiltrate(ingr)
            }
        })

        val alphaAdapter = AlphaInAnimationAdapter(adapter).apply {
            // Change the durations.
            setDuration(750)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }


        rv?.adapter = ScaleInAnimationAdapter(alphaAdapter).apply {
            // Change the durations.
            setDuration(350)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }
        rv?.addItemDecoration(
            DefaultItemDecorator(
                resources.getDimensionPixelSize(R.dimen.provider_name_horizontal_margin),
                resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin)
            )
        )
        rv?.layoutManager = LinearLayoutManager(activity)

        //viene lanciata la funzione SwipeToDelete che permette di eliminare
        // gli ingredienti presenti in dispensa
        val item  = object : SwipeToDelete(requireActivity(),0,ItemTouchHelper.LEFT){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //adapter.del(viewHolder.absoluteAdapterPosition)
                //dispensaViewModel.delete(dispensa)
                var dis=dispensaViewModel.allprod.value
                var discanc= dis?.get(viewHolder.bindingAdapterPosition)
                adapter.elem.remove(this)
                if (discanc != null) {
                    dispensaViewModel.delete(discanc)
                }
            }
        }

        val itemTouchHelper = ItemTouchHelper(item)
        itemTouchHelper.attachToRecyclerView(rv)


        activity?.let {
            dispensaViewModel.allprod.observe(it) { prods ->
                // Update the cached copy of the words in the adapter.
                prods.let { adapter.submitList(it) }

                //al click del bottone Aggiungi, viene l'anciata l'activity
                // utilizzata per inserire i prodotti in dispensa
                bt?.setOnClickListener {
                    val intent = Intent(activity, Activity_inserisci_dispensa::class.java)
                    startActivityForResult(intent, newDispensaActivityRequestCode)
                }
            }
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Dispensa"
    }

    /**
     * Con questa funzione si verifica se l'inserimento del prodotto va o meno a buon fine
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newDispensaActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(Activity_inserisci_dispensa.EXTRA_REPLY)?.let { reply ->
                //se l'inserimento va a buon fine, viene inserito il prodotto in dispensa
                val dispensa = DispensaDBEntity(reply)
                dispensaViewModel.insert(dispensa)

            }
        }else {
            //altrimenti viene lanciato un messaggio di errore
            //di non inserimento del prodotto in dispensa
                Toast.makeText(
                    context,
                    "Non hai inserito un prodotto",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

    /**
     * attraverso questa funzione è possibile filtrare le ricette per ingredienti,
     * utilizzando i prodotti presenti in dispensa
     */
    fun getRicetteFiltrate(ingr: MutableList<String>) {

        //vengono scaricate le ricette da firebase
        dbref = FirebaseDatabase.getInstance().getReference("")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (ricetteSnapshot in snapshot.children) {
                        val ricetta = ricetteSnapshot.getValue(Ricetta::class.java)
                        if (ingr!=null) {
                            for(j in ingr){
                                var appoggio= mutableListOf<String>()
                                for (ing in ricetta?.Ingredienti!!){
                                    //vengono qui inseriti nella MutableList
                                    // tutti gli ingredienti presenti in dispensa
                                    appoggio.add(ing.toLowerCase())
                                }
                                if (appoggio.contains(j.toLowerCase())){
                                    //se l'array che contiene tutte le ricette con gli ingredienti inseriti
                                    //non contiene una ricetta avente almeno uno degli ingredienti inseriti in dispensa
                                    //questa viene aggiunta
                                    if (!ricettaArray.contains(ricetta!!))
                                    ricettaArray.add(ricetta!!)
                                }
                            }

                        }

                    }
                    //nella recyclerview viene quindi visualizzato l'array contenente
                    //le ricette che rispettano i vincoli di filtraggio per ingredienti
                    recView.adapter = context?.let { RicettaAdapterDispensa(ricettaArray, it,ingr) }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}
