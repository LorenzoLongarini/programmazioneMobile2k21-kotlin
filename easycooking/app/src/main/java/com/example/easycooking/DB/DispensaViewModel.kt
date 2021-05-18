package com.example.easycooking.DB

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.easycooking.adapter.dispensa.DispensaRepository

class DispensaViewModel(private val repository: DispensaRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allprod: LiveData<List<DispensaDBEntity>> = repository.asLiveData()

    
}