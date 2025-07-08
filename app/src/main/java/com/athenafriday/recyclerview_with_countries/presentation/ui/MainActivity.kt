package com.athenafriday.recyclerview_with_countries.presentation.ui


import android.os.Bundle
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
import com.athenafriday.recyclerview_with_countries.presentation.viewmodel.CountriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CountriesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.RecyclerViewCountries)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel = ViewModelProvider(this)[CountriesViewModel::class.java]
        val recyclerViewCountries = findViewById<RecyclerView>(R.id.RecyclerViewCountries)

        adapter = CountriesRecyclerViewAdapter(emptyList())
        recyclerViewCountries.layoutManager = LinearLayoutManager(this)
        recyclerViewCountries.adapter = adapter

        viewModel.countries.observe(this) { countriesList ->
            adapter.updateCountries(countriesList)
        }

        viewModel.error.observe(this) { errorMsg ->
            Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
        }

        viewModel.fetchCountries()

    }
}