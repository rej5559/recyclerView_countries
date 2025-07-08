package com.athenafriday.recyclerview_with_countries.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.athenafriday.recyclerview_with_countries.data.model.CountriesModel
import com.athenafriday.recyclerview_with_countries.data.remote.CountriesApiClient
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    private val _countries = MutableLiveData<CountriesModel>()
    val countries: LiveData<CountriesModel> = _countries

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchCountries() {
        viewModelScope.launch {
            try {
                val response = CountriesApiClient.api.getCountries()
                if (response.isSuccessful && response.body() != null) {
                    _countries.value = response.body()
                } else {
                    _error.value = "Error: ${response.code()}"
                }

            } catch (e: Exception) {
                _error.value = "Exception: ${e.message}"
            }
        }
    }

}