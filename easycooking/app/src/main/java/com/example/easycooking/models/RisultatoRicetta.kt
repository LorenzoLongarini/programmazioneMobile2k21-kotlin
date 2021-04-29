package com.example.easycooking.models

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.easycooking.databinding.FragmentOverviewBinding

class RisultatoRicetta : Fragment() {

    private val viewModel: RicettaModel by lazy {
        ViewModelProvider(this).get(RicettaModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwener = this
        binding.view
    }

}