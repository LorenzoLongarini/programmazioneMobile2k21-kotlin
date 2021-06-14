package com.example.easycooking.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.easycooking.R

/**
 * Fragment in cui sono contenuti i link alle pagine istagram
 * e tasto per contattare gli sviluppatori della app
 */

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
        (activity as AppCompatActivity).supportActionBar?.title = "Contattaci"
        val ric8: CardView = view?.findViewById<CardView>(R.id.ric8)
        val melmag: CardView = view?.findViewById<CardView>(R.id.melmag)
        val mail:Button=view?.findViewById<Button>(R.id.mail)

        //cliccando sopra l'immagine, rimanda alla pagina instragram di Ricette a 8 bit
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

        //cliccando sopra l'immagine, rimanda alla pagina instragram di MelaMagno
        melmag.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.instagram.com/mela_magno/")
            var likeIng:Intent = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng);
            } catch (activitynotfound: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/mela_magno/")));
            }
        }

        //cliccando sul bottone, permette di inviare una mail agli sviluppatori della app
        mail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:easycookingclm@gmail.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))
        }


    }
}