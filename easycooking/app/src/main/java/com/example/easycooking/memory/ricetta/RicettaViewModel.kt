package com.example.easycooking.memory.ricetta

import androidx.lifecycle.*


import kotlinx.coroutines.launch

class RicettaViewModel (private val repository: RicettaRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allprod: LiveData<List<RicettaDBEntity>> = repository.allprod.asLiveData()

    /**
     * funzione che permette di inserire una ricetta
     */
    fun insert(ricetta: RicettaDBEntity) = viewModelScope.launch {
        repository.insert(ricetta)
    }

    /**
     * funzione che permette di eliminare una ricetta
     */
    fun delete(ricetta: RicettaDBEntity) = viewModelScope.launch {
        repository.delete(ricetta)
    }

    /**
     * funzione che consente l'interazione con il viewModel della ricetta
     */
    class RicettaViewModelFactory(private val repository: RicettaRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RicettaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return RicettaViewModel(repository) as T
            }
            throw IllegalArgumentException("Classe ViewModel sconosciuta")
        }

    }
}