package com.athenafriday.recyclerview_with_countries.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.athenafriday.recyclerview_with_countries.data.model.CountriesModel
import com.athenafriday.recyclerview_with_countries.data.remote.CountriesApiClient
import com.athenafriday.recyclerview_with_countries.data.repository.CountriesRepository
import com.athenafriday.recyclerview_with_countries.domain.usecase.GetCountriesUseCase
import com.athenafriday.recyclerview_with_countries.presentation.state.CountriesUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    private val repository = CountriesRepository()
    private val getCountriesUseCase = GetCountriesUseCase(repository)

    private val _uiState = MutableLiveData<CountriesUiState>()
    val uiState: LiveData<CountriesUiState> = _uiState

    fun fetchCountries() {
        _uiState.value = CountriesUiState.Loading
        viewModelScope.launch {
            try {
                delay(1000)
                val result = getCountriesUseCase()
                _uiState.value = CountriesUiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = CountriesUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

}