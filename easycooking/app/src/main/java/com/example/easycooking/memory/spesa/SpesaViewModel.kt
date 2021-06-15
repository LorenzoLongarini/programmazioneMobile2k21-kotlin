package com.example.easycooking.memory.spesa

import androidx.lifecycle.*

import kotlinx.coroutines.launch

class SpesaViewModel(private val repository: SpesaRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allprod: LiveData<List<SpesaDBEntity>> = repository.allprod.asLiveData()

    /**
     * funzione che permette di inserire un prodotto nella lista della spesa
     */
    fun insert(spesa: SpesaDBEntity) = viewModelScope.launch {
        repository.insert(spesa)
    }

    /**
     * funzione che permette di eliminare un prodotto dalla lista della spesa
     */
    fun delete(spesa: SpesaDBEntity) = viewModelScope.launch {
        repository.delete(spesa)
    }
}

/**
 * funzione che consente l'interazione con il viewModel della spesa
 */
class SpesaViewModelFactory(private val repository: SpesaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SpesaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SpesaViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel sconosciuta")
    }

}