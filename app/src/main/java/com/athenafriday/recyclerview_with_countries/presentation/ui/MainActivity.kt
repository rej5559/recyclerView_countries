package com.athenafriday.recyclerview_with_countries.presentation.ui


import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.athenafriday.recyclerview_with_countries.R
import com.athenafriday.recyclerview_with_countries.presentation.adapter.CountriesRecyclerViewAdapter
import com.athenafriday.recyclerview_with_countries.presentation.state.CountriesUiState
import com.athenafriday.recyclerview_with_countries.presentation.viewmodel.CountriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CountriesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CardHeader)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel = ViewModelProvider(this)[CountriesViewModel::class.java]
        val recyclerViewCountries = findViewById<RecyclerView>(R.id.RecyclerViewCountries)

        adapter = CountriesRecyclerViewAdapter(emptyList())
        recyclerViewCountries.layoutManager = LinearLayoutManager(this)
        recyclerViewCountries.adapter = adapter

        val progressBar = findViewById<ProgressBar>(R.id.ProgressBarLoading)

        viewModel.uiState.observe(this) { state ->
            when (state) {
                CountriesUiState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is CountriesUiState.Success -> {
                    progressBar.visibility = View.GONE
                    adapter.updateCountries(state.countries)
                }
                is CountriesUiState.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.fetchCountries()
    }
}