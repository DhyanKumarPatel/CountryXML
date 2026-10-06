package com.example.sampletest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sampletest.data.model.CountryItem
import com.example.sampletest.databinding.ItemCountryBinding

class CountryAdapter: ListAdapter<CountryItem, CountryAdapter.CountryViewHolder>(CountryDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryAdapter.CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CountryViewHolder(private val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(country: CountryItem){
            binding.tvNameRegion.text = "${country.name}, ${country.region}"

            binding.tvCode.text = country.code

            binding.tvCapital.text = country.capital
        }
    }

    class CountryDiffCallback: DiffUtil.ItemCallback<CountryItem>(){
        override fun areItemsTheSame(
            oldItem: CountryItem,
            newItem: CountryItem
        ): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(
            oldItem: CountryItem,
            newItem: CountryItem
        ): Boolean {
            return oldItem == newItem
        }

    }

}