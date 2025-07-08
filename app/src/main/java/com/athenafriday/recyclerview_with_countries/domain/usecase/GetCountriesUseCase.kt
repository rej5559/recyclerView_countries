package com.athenafriday.recyclerview_with_countries.domain.usecase

import com.athenafriday.recyclerview_with_countries.data.model.CountriesModel
import com.athenafriday.recyclerview_with_countries.data.repository.CountriesRepository

class GetCountriesUseCase(private val repository: CountriesRepository){
    suspend operator fun invoke(): CountriesModel {
        return repository.getCountries()
    }
}