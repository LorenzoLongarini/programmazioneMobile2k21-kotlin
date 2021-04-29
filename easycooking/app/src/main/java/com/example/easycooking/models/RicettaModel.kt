import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easycooking.network.Ricetta
import kotlinx.coroutines.launch

enum class RicettaApiStatus { LOADING, ERROR, DONE }
/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<RicettaApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<RicettaApiStatus>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsProperty
    // with new values
    private val _properties = MutableLiveData<List<Ricetta>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val properties: LiveData<List<Ricetta>>
        get() = _properties

    // Internally, we use a MutableLiveData to handle navigation to the selected property
    private val _navigateToSelectedProperty = MutableLiveData<Ricetta>()

    // The external immutable LiveData for the navigation property
    val navigateToSelectedProperty: LiveData<Ricetta>
        get() = _navigateToSelectedProperty



    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     * da vedere
     */
    init {
        getProprietaRicette(RicettaApiFilter.SHOW_ALL)
    }

    /**
     * Gets filtered Mars real estate property information from the Mars API Retrofit service and
     * updates the [MarsProperty] [List] and [MarsApiStatus] [LiveData]. The Retrofit service
     * returns a coroutine Deferred, which we await to get the result of the transaction.
     * @param filter the [MarsApiFilter] that is sent as part of the web server request
     */
    private fun getProprietaRicette(filter: RicettaApiFilter) {
        viewModelScope.launch {
            _status.value = RicettaApiStatus.LOADING
            try {
                _properties.value = RicettaApi.retrofitService.getProperties(filter.value)
                _status.value = RicettaApiStatus.DONE
            } catch (e: Exception) {
                _status.value = RicettaApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    /**
     */

    /**
     * When the property is clicked, set the [_navigateToSelectedProperty] [MutableLiveData]
     * @param marsProperty The [MarsProperty] that was clicked on.
     */
    fun displayPropertyDetails(ricetta: Ricetta) {
        _navigateToSelectedProperty.value = ricetta
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    /**
     * Updates the data set filter for the web services by querying the data with the new filter
     * by calling [getMarsRealEstateProperties]
     * @param filter the [MarsApiFilter] that is sent as part of the web server request
     */
    fun updateFilter(filter: RicettaApiFilter) {
        getProprietaRicette(filter)
    }
}