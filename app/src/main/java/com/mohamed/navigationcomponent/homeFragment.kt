package com.mohamed.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class homeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        root.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navHostFragment.navController)

        val toolbar = root.findViewById<Toolbar>(R.id.toolbar)


        // Custom navigation listener allows me to change the title
        navHostFragment.navController.addOnDestinationChangedListener {
                _, destination, _ ->
            toolbar.title = destination.label.toString()
        }
        return root
    }

}
