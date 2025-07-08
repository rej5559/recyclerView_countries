package com.athenafriday.recyclerview_with_countries.presentation.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.athenafriday.recyclerview_with_countries.R
import com.athenafriday.recyclerview_with_countries.data.model.CountryModel

class CountriesRecyclerViewAdapter(private var countries: List<CountryModel>):
    RecyclerView.Adapter<CountriesRecyclerViewAdapter.CountriesViewHolder>() {

    inner class CountriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val TVName: TextView = itemView.findViewById(R.id.TVName)
        val TVRegion: TextView = itemView.findViewById(R.id.TVRegion)
        val TVCode: TextView = itemView.findViewById(R.id.TVCode)
        val TVCapital: TextView = itemView.findViewById(R.id.TVCapital)
    }

    fun updateCountries(newList: List<CountryModel>) {
        countries = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_row, parent, false)
        return CountriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val country = countries[position]
        holder.TVName.text = country.name ?: "name Unknown"
        holder.TVCode.text = country.code ?: "Code Unknown"
        holder.TVRegion.text = country.region ?: "Region Unknown"
        holder.TVCapital.text = country.capital ?: "Capital Unknown"
    }
}