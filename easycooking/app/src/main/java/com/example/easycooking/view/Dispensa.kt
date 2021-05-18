import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.easycooking.DB.AppDatabase
import com.example.easycooking.R
import com.example.easycooking.adapter.dispensa.DefaultItemDecorator
import com.example.easycooking.adapter.dispensa.MyAdapter
import com.example.easycooking.view.Activity_inserisci_dispensa
import com.example.easycooking.view.Base_nonReg
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.fragment_dispensa.*


class dispensaFrag: Fragment(R.layout.fragment_dispensa) {



    companion object {

        fun newInstance(): dispensaFrag {
            return dispensaFrag()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_dispensa, container, false)
        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val bt: Button? =view?.findViewById<Button>(R.id.bt)

        val db = context?.let {
            Room.databaseBuilder(
                it,
                AppDatabase::class.java, "dispensa"
            )   .allowMainThreadQueries()
                .build()
        }

        val dbDAO=db?.DispensaDAO()
        val appoggio = dbDAO?.getAll()


        val rv: RecyclerView? = view?.findViewById<RecyclerView>(R.id.rv)
       // var appoggio=mutableListOf<Dispensa>()
        rv?.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior

            layoutManager = LinearLayoutManager(activity)
            //adapter = MyAdapter(appoggio)
            // set the custom adapter to the RecyclerView
            /*ar Dis1=Dispensa("gelato",10,"scatole")
            var Dis2=Dispensa("capperi",2,"barattoli")
            var Dis3= Dispensa("pennette",300,"grammi")
            var Dis11=Dispensa("gelato",10,"scatole")
            var Dis12=Dispensa("capperi",2,"barattoli")
            var Dis13=Dispensa("pennette",300,"grammi")
            var Dis111=Dispensa("gelato",10,"scatole")
            var Dis112=Dispensa("capperi",2,"barattoli")
            var Dis113=Dispensa("pennette",300,"grammi")
            var Dis1111=Dispensa("gelato",10,"scatole")
            var Dis1112=Dispensa("capperi",2,"barattoli")
            var Dis1113=Dispensa("pennette",300,"grammi")
            var Dis4=Dispensa("gelato",10,"scatole")
            var Dis5=Dispensa("capperi",2,"barattoli")
            var Dis6=Dispensa("pennette",300,"grammi")

            var appoggio=mutableListOf<Dispensa>(Dis1,Dis2,Dis3,Dis11,Dis12,Dis13,Dis111,Dis112,Dis113,Dis1111,Dis1112,Dis1113,Dis4,Dis5,Dis6)*/


            rv?.addItemDecoration(
                DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.provider_name_horizontal_margin),
                resources.getDimensionPixelSize(R.dimen.provider_name_vertical_margin))
            )


            val alphaAdapter = appoggio?.let { MyAdapter(it) }?.let {
                AlphaInAnimationAdapter(it).apply {
                    // Change the durations.
                    setDuration(750)
                    // Disable the first scroll mode.
                    setFirstOnly(false)
                }
            }
            rv?.adapter = alphaAdapter?.let {
                ScaleInAnimationAdapter(it).apply {
                    // Change the durations.
                    setDuration(350)
                    // Disable the first scroll mode.
                    setFirstOnly(false)
                }
            }

        }



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
            val intent= Intent(context, Activity_inserisci_dispensa::class.java)
            context?.startActivity(intent)

        }


    }
}