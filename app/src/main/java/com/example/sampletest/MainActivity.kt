package com.example.sampletest

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampletest.databinding.ActivityMainBinding
import com.example.sampletest.ui.CountryAdapter
import com.example.sampletest.ui.CountryUiState
import com.example.sampletest.ui.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryAdapter: CountryAdapter

    private val viewModel: CountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        observeUiState()
    }

    private fun observeUiState() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when(state){
                    is CountryUiState.Loading -> {
                        showLoading()
                    }

                    is CountryUiState.Success -> {
                        showCountries()

                        countryAdapter.submitList(state.countries)
                    }

                    is CountryUiState.Error -> {
                        showError(state.message)
                    }

                }
            }
        }
    }

    fun showError(message: String) {
        binding.progressBar.visibility = View.GONE

        binding.recyclerViewCountries.visibility = View.GONE

        binding.errorLayout.visibility = View.VISIBLE

        binding.tvError.text = message


    }

    fun showCountries() {
        binding.progressBar.visibility = View.GONE

        binding.recyclerViewCountries.visibility = View.VISIBLE

        binding.errorLayout.visibility = View.GONE
    }

    fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE

        binding.recyclerViewCountries.visibility = View.GONE

        binding.errorLayout.visibility = View.GONE
    }

    private fun setUpRecyclerView() {
        countryAdapter = CountryAdapter()

        binding.recyclerViewCountries.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = countryAdapter

        }
    }
}