package com.mohamed.navigationcomponent.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.navigationcomponent.R

class BoatsAdapter(
    private val boats: ArrayList<Boat>,
    private val onBoatClicked: (Int) -> Unit
) : RecyclerView.Adapter<BoatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoatsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.boat_list_item, parent,
                false
            )

        return BoatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoatsViewHolder, position: Int) {
        holder.bind(boats.get(position), onBoatClicked)
    }

    override fun getItemCount(): Int {
        return boats.size
    }


}