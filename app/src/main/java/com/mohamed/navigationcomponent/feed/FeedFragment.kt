package com.mohamed.navigationcomponent.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamed.navigationcomponent.R
import com.mohamed.navigationcomponent.homeFragmentDirections
import kotlinx.android.synthetic.main.fragment_feed.view.*


class FeedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_feed, container, false)
        root.recycler.adapter = BoatsAdapter(ArrayList(BOATS), ::onBoatClick)
        root.recycler.layoutManager = LinearLayoutManager(root.context)
        return root
    }
    private fun onBoatClick(boatId: Int) {
        val action = homeFragmentDirections.actionHomeFragmentToBoatDetailsFragment(boatId)
        activity?.findNavController(R.id.nav_container)?.navigate(action)
    }
}
