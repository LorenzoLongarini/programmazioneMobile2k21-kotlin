package com.example.easycooking.DB

import androidx.lifecycle.*
import com.example.easycooking.adapter.dispensa.DispensaRepository
import kotlinx.coroutines.launch

class DispensaViewModel(private val repository: DispensaRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allprod: LiveData<List<DispensaDBEntity>> = repository.allprod.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(dispensa: DispensaDBEntity) = viewModelScope.launch {
        repository.insert(dispensa)
    }
}

class DispensaViewModelFactory(private val repository: DispensaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DispensaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DispensaViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel sconosciuta")
    }

}