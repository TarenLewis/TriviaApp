package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Sets makes the 'About' menu visible in the title fragment
        setHasOptionsMenu(true)

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)


        /*
        // An optional way to create the on click listener action, with Navigation. There are alternative methods located below.
        binding.playButton.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        }*/

        binding.playButton.setOnClickListener { view: View ->

            // This line can be replaced, via Jetpack project Android KTX extension functions, which allow a class to extend the functionality of
            // an existing class, without subclassing it. KTX has an extension function for the View class. This is the original line:
             Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
            // and the replacement:
            //view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)

        }


        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }


}
