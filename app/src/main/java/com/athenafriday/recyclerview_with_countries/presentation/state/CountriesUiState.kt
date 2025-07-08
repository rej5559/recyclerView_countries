package com.athenafriday.recyclerview_with_countries.presentation.state

import com.athenafriday.recyclerview_with_countries.data.model.CountryModel

sealed class CountriesUiState {
    object Loading : CountriesUiState()
    data class Success(val countries: List<CountryModel>): CountriesUiState()
    data class Error(val message: String): CountriesUiState()
}