package com.example.sampletest.data.repository

import com.example.sampletest.data.model.Country

interface CountryRepository {
    suspend fun getCountries(): Country
}