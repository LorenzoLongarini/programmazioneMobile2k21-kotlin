package com.example.easycooking.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easycooking.DB.DispensaApplication
import com.example.easycooking.DB.DispensaDBEntity
import com.example.easycooking.DB.DispensaViewModel
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.dispensa.DispensaListAdapter
import com.example.easycooking.adapter.ricetta.*
import com.example.easycooking.spesa.Activity_compra.Companion.EXTRAs_REPLY
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter

class RicetteTue : Fragment(R.layout.fragment_ricettetue) {
    private val newRicettaActivityRequestCode = 1
    private val ricettaViewModel: RicettaViewModel by viewModels {
        RicettaViewModel.RicettaViewModelFactory((activity?.application as DispensaApplication).repositoryRicetta)
    }
    private val REQUEST_PERMISSION = 100
    val adapter = RicettaListAdapter()

        companion object {

            fun newInstance(): RicetteTue {
                return RicetteTue()
            }
        }



        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view: View = inflater.inflate(R.layout.fragment_ricettetue, container, false)
            return view
        }


    override fun onResume() {
        super.onResume()
        checkCameraPermission()
        checkGalleryPermission()
    }


        override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
            super.onViewCreated(itemView, savedInstanceState)
            (activity as AppCompatActivity).supportActionBar?.title = "Le tue ricette"
            val bot = view?.findViewById<Button>(R.id.bottone_aggiungi_ricetta)
            val rev = view?.findViewById<RecyclerView>(R.id.rv)



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
                    var ric=ricettaViewModel.allprod.value
                    var discanc= ric?.get(viewHolder.bindingAdapterPosition)
                    adapter.elemo.remove(this)
                    if (discanc != null) {
                        ricettaViewModel.delete(discanc)
                    }
                }
            }

            val itemTouchHelper = ItemTouchHelper(item)
            itemTouchHelper.attachToRecyclerView(rev)


            activity?.let {
                ricettaViewModel.allprod.observe(it) { prods ->
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


                    bot?.setOnClickListener {

                        if ((this.context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) }
                                    != PackageManager.PERMISSION_GRANTED
                                    ) && (this.context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.READ_EXTERNAL_STORAGE) }
                                    != PackageManager.PERMISSION_GRANTED
                                    )){
                        val intent = Intent(activity, Inserisci_ricetta_noPermessi::class.java)
                        startActivityForResult(intent, newRicettaActivityRequestCode)} else{
                            val intent = Intent(activity, Inserisci_ricetta::class.java)
                            startActivityForResult(intent, newRicettaActivityRequestCode)
                        }
                    }
                }
            }

        }

    /**
     * attraverso questa funzione, vengono richiesti i permessi di accesso alla fotocamera del telefono
     */
    private fun checkCameraPermission() {
        if (this.context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) }
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this.activity as Activity,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_PERMISSION
            )
        }
    }

    /**
     * attraverso questa funzione, vengono richiesti i permessi di accesso alla galleria del telefono
     */
    private fun checkGalleryPermission() {
        if (this.context?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.READ_EXTERNAL_STORAGE) }
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this.activity as Activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                REQUEST_PERMISSION
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
            super.onActivityResult(requestCode, resultCode, intentData)

            if (requestCode == newRicettaActivityRequestCode && resultCode == Activity.RESULT_OK) {
                //var quant = intentData?.getStringExtra("quant")
                //var unit = intentData?.getStringExtra("unit")
                intentData?.getStringExtra(Inserisci_ricetta.EXTRAs_REPLY)?.let { reply ->
                    val ricetta = RicettaDBEntity(reply,
                        intentData?.getStringExtra("ingredienti")!!,
                        intentData?.getStringExtra("tempo_cott")!!,
                        intentData?.getStringExtra("photo"),
                        intentData?.getStringExtra("porzioni")!!,
                        intentData?.getStringExtra("tempo_prep")!!,
                        intentData?.getStringExtra("procedimento")!!,
                        intentData?.getStringExtra("tempo_tot"),
                        intentData?.getIntExtra("aiutolettura",0))

                    ricettaViewModel.insert(ricetta)

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