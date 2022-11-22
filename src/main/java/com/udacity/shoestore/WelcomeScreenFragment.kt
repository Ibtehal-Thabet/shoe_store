package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.WelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: WelcomeScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_screen, container, false)

        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeScreen_to_instructionsFragment)
        }
        return binding.root
    }

}