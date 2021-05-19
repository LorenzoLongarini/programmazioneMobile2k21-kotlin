import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.NonNull

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.easycooking.DB.*

import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.dispensa.DispensaListAdapter

import com.example.easycooking.view.Activity_inserisci_dispensa
import com.example.easycooking.view.Base_nonReg
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.fragment_dispensa.*


class dispensaFrag: Fragment(R.layout.fragment_dispensa) {

    private val newDispensaActivityRequestCode = 1
    private val dispensaViewModel: DispensaViewModel by viewModels {
        DispensaViewModelFactory((fragment.activity?.application as DispensaApplication).repository)
    }

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


        val rv = view?.findViewById<RecyclerView>(R.id.rv)
        val adapter = DispensaListAdapter()
        rv?.adapter = adapter
        rv?.layoutManager = LinearLayoutManager(activity)

        activity?.let {
            dispensaViewModel.allprod.observe(it) { prods ->
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


                bt?.setOnClickListener {
                    val intent = Intent(activity, Activity_inserisci_dispensa::class.java)
                    startActivityForResult(intent, newDispensaActivityRequestCode)
                }
            }
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newDispensaActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(Activity_inserisci_dispensa.EXTRA_REPLY)?.let { reply ->
                val dispensa = DispensaDBEntity(reply,0,"kk")
                dispensaViewModel.insert(dispensa)
            }
        } else {
            Toast.makeText(
                context,
                "Non hai inserito un prodotto",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}