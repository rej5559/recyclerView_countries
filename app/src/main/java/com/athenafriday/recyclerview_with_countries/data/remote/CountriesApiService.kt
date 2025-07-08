package com.athenafriday.recyclerview_with_countries.data.remote

import com.athenafriday.recyclerview_with_countries.data.model.CountriesModel
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApiService {

    @GET(ApiConstants.COUNTRIES_ENDPOINT)
    suspend fun getCountries(): Response<CountriesModel>

}