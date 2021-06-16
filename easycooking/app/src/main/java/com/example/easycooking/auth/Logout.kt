package com.example.easycooking.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easycooking.MainActivity
import com.example.easycooking.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_logout.*

/**
 * questa classe viene utilizzata per lanciare il fragment per effettuare il logout dalla applicazione
 */

class Logout : Fragment(R.layout.fragment_logout) {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.fragment_logout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Logout"
        logout()

        }


    companion object {
        fun newInstance(): MainActivity {
            return MainActivity()
        }

    }


    //questa funzione viene utilizzata per effettuare il logout
    private fun signOut() {
        // [START auth_sign_out]
        Firebase.auth.signOut()
        // [END auth_sign_out]
    }

    private fun logout() {

        //al click sul bottone di logout, viene richiamata la funzione signOut()
        //e si viene rimandati all'activity iniziale di login
        Logout2.setOnClickListener {
            signOut()
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            Toast.makeText(
                context,
                "Logout effettuato con successo",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}