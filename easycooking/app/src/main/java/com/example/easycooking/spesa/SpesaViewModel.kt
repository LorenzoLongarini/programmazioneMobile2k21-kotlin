package com.example.easycooking.spesa

import androidx.lifecycle.*

import kotlinx.coroutines.launch

class SpesaViewModel(private val repository: SpesaRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allprod: LiveData<List<SpesaDBEntity>> = repository.allprod.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(spesa: SpesaDBEntity) = viewModelScope.launch {
        repository.insert(spesa)
    }
}

class SpesaViewModelFactory(private val repository: SpesaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SpesaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SpesaViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel sconosciuta")
    }

}