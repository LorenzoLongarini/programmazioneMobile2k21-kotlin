package com.example.easycooking.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.easycooking.MainActivity
import com.example.easycooking.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_logout.*

class Logout : Fragment(R.layout.fragment_logout) {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.fragment_logout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logout()

        }


    companion object {
        fun newInstance(): MainActivity {
            return MainActivity()
        }

    }

    private fun signOut() {
        // [START auth_sign_out]
        Firebase.auth.signOut()
        // [END auth_sign_out]
    }

    private fun logout() {

        Logout2.setOnClickListener {
            signOut()
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
        }
    }

}