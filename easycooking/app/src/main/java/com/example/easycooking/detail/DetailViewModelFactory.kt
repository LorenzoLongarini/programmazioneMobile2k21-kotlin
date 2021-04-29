package com.example.easycooking.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.easycooking.network.Ricetta

class DetailViewModelFactory(
    private val ricetta: Ricetta,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(ricetta, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}