package com.kauzganga.shoestore.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.models.Shoe

class SleepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(shoe: Shoe) {
        itemView.findViewById<TextView>(R.id.shoe_name).text = shoe.name
    }

}
