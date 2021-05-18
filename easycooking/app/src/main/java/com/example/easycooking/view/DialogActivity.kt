package com.example.easycooking.view

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.easycooking.R


class DialogActivity : AppCompatDialogFragment() {
    private var editTextNome: EditText? = null
    private var editTextQuant: EditText? = null
    private var editTextUnit: EditText? = null
    private var listener: DialogListener? = null

    @Override public fun onCreateDialog(savedInstanceState:Bundle): AlertDialog? {
      var builder = activity?.let { AlertDialog.Builder(it) }
    val inflater = requireActivity().layoutInflater


    builder?.setView(inflater.inflate(R.layout.dialog, null))
    ?.setTitle("Inserisci in dispensa:")
        ?.setNegativeButton("Annulla",
            DialogInterface.OnClickListener { dialog, id ->

            })
        ?.setPositiveButton("Aggiungi",
            DialogInterface.OnClickListener { dialog, id->
                var nomeProdotto:String = editTextNome?.text.toString()
                var quantProdotto:Int = editTextQuant?.text.toString().toInt()
                var unitProdotto:String = editTextUnit?.text.toString()

                listener?.applyTexts(nomeProdotto,quantProdotto,unitProdotto)
            })

    editTextNome = view?.findViewById(R.id.nomeProdotto)
    editTextQuant = view?.findViewById(R.id.quantitaProdotto)
    editTextUnit = view?.findViewById(R.id.unitaProdotto)


            return builder?.create()

}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as DialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString().toString() +
                        "must implement ExampleDialogListener"
            )
        }
    }

 interface DialogListener {
    fun applyTexts(nome:String,quant:Int,unit:String);
}
}