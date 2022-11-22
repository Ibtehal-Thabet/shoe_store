package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeListViewBinding
import com.udacity.shoestore.models.ListViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel


class ShoeListFragment : Fragment() {

    private val listViewModel: ListViewModel by activityViewModels()
    private lateinit var shoeViewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)

        binding.addItemButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        @Suppress("DEPRECATION")
        this.setHasOptionsMenu(true)

        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.viewModel = shoeViewModel
        listViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList->
            for(shoe in shoeList)
                addShoe(shoe, container)
        })


        return binding.root
    }


    private fun addShoe(shoe: Shoe, container: ViewGroup?) {
        val shoeListViewBinding: ShoeListViewBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.shoe_list_view, container, false)
        shoeListViewBinding.shoe = shoe
        binding.myLinearLayout.addView(shoeListViewBinding.root)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater?.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        @Suppress("DEPRECATION")
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}