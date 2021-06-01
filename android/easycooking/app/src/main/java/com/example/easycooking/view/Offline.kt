package com.example.easycooking.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.DB.DispensaApplication
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.offline.OfflineAdapter
import com.example.easycooking.adapter.offline.OfflineDBEntity
import com.example.easycooking.adapter.offline.OfflineViewModel
import com.example.easycooking.adapter.ricetta.*
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class Offline : Fragment() {
    private val newRicettaActivityRequestCode = 1
    private val offlineViewModel: OfflineViewModel by viewModels {
        OfflineViewModel.OfflineViewModelFactory((activity?.application as DispensaApplication).repositoryOffline)
    }
    val adapter = OfflineAdapter()

    companion object {

        fun newInstance(): RicetteTue {
            return RicetteTue()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_offline, container, false)
        return view
    }




    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val rev = view?.findViewById<RecyclerView>(R.id.rv1)


        val alphaAdapter = AlphaInAnimationAdapter(adapter).apply {
            // Change the durations.
            setDuration(750)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }


        rev?.adapter = ScaleInAnimationAdapter(alphaAdapter).apply {
            // Change the durations.
            setDuration(350)
            // Disable the first scroll mode.
            setFirstOnly(false)
        }
        rev?.addItemDecoration(
            DefaultItemDecorator(
                resources.getDimensionPixelSize(R.dimen.provider_name_horizontal_margin),
                resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin)
            )
        )
        rev?.layoutManager = GridLayoutManager(activity,2)

        val item  = object :SwipeToDelete(requireActivity(),0, ItemTouchHelper.LEFT){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //adapter.del(viewHolder.absoluteAdapterPosition)
                //dispensaViewModel.delete(dispensa)
                var ric=offlineViewModel.offprod.value
                var discanc= ric?.get(viewHolder.bindingAdapterPosition)
                adapter.elemo1.remove(this)
                if (discanc != null) {
                    offlineViewModel.delete(discanc)
                }
            }
        }

        val itemTouchHelper = ItemTouchHelper(item)
        itemTouchHelper.attachToRecyclerView(rev)


        activity?.let {
            offlineViewModel.offprod.observe(it) { prods ->
                // Update the cached copy of the words in the adapter.
                prods.let { adapter.submitList(it) }


                /*val inflater = requireActivity().layoutInflater
                var nome:EditText?=view?.findViewById<EditText>(R.id.nomeProdotto)
                val builder: AlertDialog.Builder?=activity?.let{
                    AlertDialog.Builder(it)
                }
                builder?.setTitle("Inserisci in dispensa:")
                    ?.apply {
                        setView(inflater.inflate(R.layout.dialog,null))
                        setPositiveButton("Aggiungi",
                            DialogInterface.OnClickListener { dialog, id->



                               // var added=Dispensa(nomeProdotto.text.toString(),quantitaProdotto.text.toString().toInt(),quantitaProdotto.text.toString())
                                //appoggio.plus(added)
                                    liste
                                    Toast.makeText(activity, nome?.text.toString(), Toast.LENGTH_LONG).show()

                            })
                        setNegativeButton("Annulla",
                            DialogInterface.OnClickListener { dialog, id ->

                            })

                    }



                val dialog: AlertDialog? = builder?.create()*/
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newRicettaActivityRequestCode && resultCode == Activity.RESULT_OK) {
            //var quant = intentData?.getStringExtra("quant")
            //var unit = intentData?.getStringExtra("unit")
            intentData?.getStringExtra(Inserisci_ricetta.EXTRAs_REPLY)?.let { reply ->
                val ricetta = OfflineDBEntity(reply,
                    intentData?.getStringExtra("ingredienti")!!,
                    intentData?.getStringExtra("tempo_cott")!!,
                   // intentData?.getStringExtra("photo"),
                    intentData?.getStringExtra("porzioni")!!,
                    intentData?.getStringExtra("tempo_prep")!!,
                    intentData?.getStringExtra("procedimento")!!,
                    intentData?.getStringExtra("totalTime")!!,
                    intentData?.getStringExtra("preparaz")!!,
                   //intentData?.getStringExtra("quantProdotto")!!,
                    //intentData?.getStringExtra("unitProdotto")!!
                )

                offlineViewModel.insert(ricetta)

            }
        }else {
            Toast.makeText(
                context,
                "Non hai inserito una ricetta",
                Toast.LENGTH_LONG
            ).show()
        }

    }

}