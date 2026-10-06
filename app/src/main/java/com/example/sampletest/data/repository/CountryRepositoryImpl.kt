package com.example.sampletest.data.repository

import com.example.sampletest.data.model.Country
import com.example.sampletest.data.remote.CountryApiService
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(private val apiService: CountryApiService): CountryRepository {
    override suspend fun getCountries(): Country {
        return apiService.getCountries()
    }

}