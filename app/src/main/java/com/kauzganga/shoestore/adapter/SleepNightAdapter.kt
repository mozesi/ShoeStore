package com.kauzganga.shoestore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.models.Shoe

class SleepNightAdapter: Adapter<SleepViewHolder>() {

    var shoes = listOf<Shoe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        val shoeViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.shoe_item,parent,false)
        return SleepViewHolder(shoeViewHolder)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
            holder.bind(shoes[position])
    }

    override fun getItemCount() = shoes.size
}