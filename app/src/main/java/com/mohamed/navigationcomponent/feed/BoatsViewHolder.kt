package com.mohamed.navigationcomponent.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.boat_list_item.view.*

class BoatsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val nameTextView = itemView.nameTextView
    private val locationTextView = itemView.locationTextView
    private val imageView = itemView.imageView2
    private val priceTextView = itemView.priceTextView

    fun bind(boat: Boat, onBoatClick: (Int) -> Unit) {
        nameTextView.text = boat.name
        locationTextView.text = boat.location
        imageView.setImageResource(boat.picture)
        priceTextView.text = boat.price
        itemView.setOnClickListener { onBoatClick(boat.id) }
    }
}