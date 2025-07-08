package com.athenafriday.recyclerview_with_countries.data.repository

import com.athenafriday.recyclerview_with_countries.data.model.CountriesModel
import com.athenafriday.recyclerview_with_countries.data.remote.CountriesApiClient

class CountriesRepository {
    open suspend fun getCountries(): CountriesModel {
        val response = CountriesApiClient.api.getCountries()
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!
        } else {
            throw Exception("Failed to load countries: ${response.message()}")
        }
    }
}