package com.example.easycooking.adapter.offline

import androidx.lifecycle.*
import com.example.easycooking.adapter.ricetta.Ricetta

import kotlinx.coroutines.launch

class OfflineViewModel (private val repository: OfflineRepository):ViewModel(){

    val offprod: LiveData<List<OfflineDBEntity>> = repository.offprod.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(ric: OfflineDBEntity?) = viewModelScope.launch {
        if (ric != null) {
            repository.insert(ric)
        }
    }

    fun delete(ric: OfflineDBEntity) = viewModelScope.launch {
        repository.delete(ric)
    }

    class OfflineViewModelFactory(private val repository: OfflineRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(OfflineViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return OfflineViewModel(repository) as T
            }
            throw IllegalArgumentException("Classe ViewModel sconosciuta")
        }

    }
}