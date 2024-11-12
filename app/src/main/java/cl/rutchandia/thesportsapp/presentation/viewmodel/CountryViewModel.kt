package cl.rutchandia.thesportsapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.rutchandia.thesportsapp.data.remote.ApiResponseState
import cl.rutchandia.thesportsapp.domain.model.Country
import cl.rutchandia.thesportsapp.domain.usecase.GetFilteredCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getFilteredCountriesUseCase: GetFilteredCountriesUseCase
) : ViewModel() {

    var apiState = mutableStateOf<ApiResponseState<List<Country>>?>(null)
        private set

    var countryList = MutableStateFlow<List<Country>?>(null)
        private set

    init {
        fetchFilteredCountries()
    }

    private fun fetchFilteredCountries() {
        if (countryList.value != null) return

        apiState.value = ApiResponseState.Loading()

        viewModelScope.launch(Dispatchers.IO) {
            val response = getFilteredCountriesUseCase.invoke()

            withContext(Dispatchers.Main) {
                if (response is ApiResponseState.Success) {
                    updateCountryList(response.data)
                }
                apiState.value = response
            }
        }
    }

    private fun updateCountryList(list: List<Country>) {
        countryList.value = list
    }

    fun resetApiStatus() {
        apiState.value = null
    }

    fun tryAgain() {
        fetchFilteredCountries()
    }
}
