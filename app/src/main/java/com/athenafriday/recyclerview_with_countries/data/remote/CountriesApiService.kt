package com.athenafriday.recyclerview_with_countries.data.remote

import com.athenafriday.recyclerview_with_countries.data.model.CountriesModel
import retrofit2.Response
import retrofit2.http.GET

interface CountriesApiService {

    @GET("/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountries(): Response<CountriesModel>

}