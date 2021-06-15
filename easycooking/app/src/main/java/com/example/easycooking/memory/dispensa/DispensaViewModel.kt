package com.example.easycooking.memory.dispensa

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class DispensaViewModel(private val repository: DispensaRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allprod: LiveData<List<DispensaDBEntity>> = repository.allprod.asLiveData()

    /**
     * funzione che permette di inserire un prodotto in dispensa
     */
    fun insert(dispensa: DispensaDBEntity) = viewModelScope.launch {
        repository.insert(dispensa)
    }

    /**
     * funzione che permette di eliminare un prodotto dalla dispensa
     */
    fun delete(dispensa: DispensaDBEntity) = viewModelScope.launch {
        repository.delete(dispensa)
    }

    /**
     * funzione che consente l'interazione con il viewModel della dispensa
     */
    class DispensaViewModelFactory(private val repository: DispensaRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DispensaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DispensaViewModel(repository) as T
            }
            throw IllegalArgumentException("Classe ViewModel sconosciuta")
        }

    }
}