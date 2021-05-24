package com.example.easycooking.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.easycooking.R


class Contattaci : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_contattaci, container, false)
        return view
    }

    companion object {
        fun newInstance(): Contattaci {
            return Contattaci()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ric8: ImageView = view?.findViewById<ImageView>(R.id.ric8bit)
        val melmag: ImageView = view?.findViewById<ImageView>(R.id.melamagno)

        ric8.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.instagram.com/ricette_a_8bit/")
             var likeIng:Intent = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng);
            } catch (activitynotfound: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/ricette_a_8bit/")));
            }
        }


    }
}