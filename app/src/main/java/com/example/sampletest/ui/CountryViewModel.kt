package com.example.sampletest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampletest.data.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(private val repository: CountryRepository): ViewModel(){

    private val _uiState = MutableStateFlow<CountryUiState>(CountryUiState.Loading)
    val uiState : StateFlow<CountryUiState> = _uiState.asStateFlow()

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            _uiState.value = CountryUiState.Loading

            try {
                val countries = repository.getCountries()

                _uiState.value = CountryUiState.Success(countries)

            } catch (e: Exception){
                _uiState.value = CountryUiState.Error(e.message ?: "Something went Wrong")
            }
        }
    }

}