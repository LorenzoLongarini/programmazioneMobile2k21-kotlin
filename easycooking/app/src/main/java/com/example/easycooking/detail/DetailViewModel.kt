package com.example.easycooking.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.easycooking.network.Ricetta

class DetailViewModel(ricetta: Ricetta, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<Ricetta>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Ricetta>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = ricetta
    }

}
