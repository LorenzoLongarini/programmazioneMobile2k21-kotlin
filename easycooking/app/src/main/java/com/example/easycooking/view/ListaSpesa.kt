package com.example.easycooking.view

/*class ListaSpesa : Fragment(R.layout.fragment_listaspesa) {
    companion object {

        fun newInstance(): ListaSpesa {
            return ListaSpesa()
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_listaspesa, container, false)
        return view
    }

}*/
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.easycooking.R
import com.example.easycooking.spesa.SpesaCont
import com.example.easycooking.spesa.SpesaDatabaseHelper
import java.util.*


class ListaSpesa : Fragment(R.layout.fragment_listaspesa) {
    private var spesaHelper: SpesaDatabaseHelper? = null
    private var SpesaList: ListView? = null
    private var arrAdapter: ArrayAdapter<String>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_listaspesa, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spesaHelper = SpesaDatabaseHelper(this.context)
        SpesaList = view?.findViewById<View>(R.id.list_todo) as ListView
        updateUI()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add_task -> {
                //
                val taskEdit = EditText(this.context)
                val dialog = this.context?.let {
                    AlertDialog.Builder(it)
                        .setTitle("Lista della spesa").setMessage("Che altro devi comprare?")
                        .setView(taskEdit)
                        .setPositiveButton(
                            "Aggiungi"
                        ) { dialog, which ->
                            val item = taskEdit.text.toString()
                            val db: SQLiteDatabase? = spesaHelper?.writableDatabase
                            val values = ContentValues()
                            values.put(SpesaCont.SpesaEntry.COL_TASK_TITLE, item)
                            db?.insertWithOnConflict(
                                SpesaCont.SpesaEntry.TABLE,
                                null,
                                values,
                                SQLiteDatabase.CONFLICT_REPLACE
                            )
                            db?.close()
                            updateUI()
                        }
                        .setNegativeButton("Annulla", null).create()
                }
                dialog?.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun deleteItem(view: View) {
        val parent = view.parent as View
        val taskTextView = parent.findViewById<View>(R.id.title_task) as TextView
        val item = taskTextView.text.toString()
        val db: SQLiteDatabase? = spesaHelper?.writableDatabase
        db?.delete(
            SpesaCont.SpesaEntry.TABLE,
            SpesaCont.SpesaEntry.COL_TASK_TITLE.toString() + " = ?",
            arrayOf(item)
        )
        db?.close()
        updateUI()
    }

    private fun updateUI() {
        val spesaList = ArrayList<String>()
        val db: SQLiteDatabase? = spesaHelper?.readableDatabase
        val cursor = db?.query(
            SpesaCont.SpesaEntry.TABLE,
            arrayOf(arrayOf(SpesaCont.SpesaEntry._ID.toString(), SpesaCont.SpesaEntry.COL_TASK_TITLE).toString()),
            null,
            null,
            null,
            null,
            null
        )
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val idx = cursor.getColumnIndex(SpesaCont.SpesaEntry.COL_TASK_TITLE)
                spesaList.add(cursor.getString(idx))
            }
        }
        if (arrAdapter == null) {
            arrAdapter = this.context?.let { ArrayAdapter(it, R.layout.item_compra, R.id.title_task, spesaList) }
            SpesaList!!.adapter = arrAdapter
        } else {
            arrAdapter!!.clear()
            arrAdapter!!.addAll(spesaList)
            arrAdapter!!.notifyDataSetChanged()
        }
        cursor?.close()
        db?.close()
    }

    companion object {
        private const val TAG = "MainActivity"
        fun newInstance(): ListaSpesa {
            return ListaSpesa()
        }
    }
}