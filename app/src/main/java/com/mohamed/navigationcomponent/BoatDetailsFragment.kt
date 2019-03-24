package com.mohamed.navigationcomponent

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamed.navigationcomponent.feed.BOATS
import kotlinx.android.synthetic.main.fragment_boat_details.view.*


class BoatDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root= inflater.inflate(R.layout.fragment_boat_details, container, false)

        val id = arguments?.let { BoatDetailsFragmentArgs.fromBundle(it).id }

        val boat = BOATS.get(id!!)
        root.nameTextView.text = boat.name
        root.locationTextView.text = boat.location
        root.imageView2.setImageResource(boat.picture)
        root.priceTextView.text = boat.price

        return root

    }


}
