package com.example.sampletest.ui

import com.example.sampletest.data.model.CountryItem

sealed class CountryUiState {
    object Loading: CountryUiState()

    data class Success(val countries: List<CountryItem>): CountryUiState()

    data class Error(val message: String): CountryUiState()
}