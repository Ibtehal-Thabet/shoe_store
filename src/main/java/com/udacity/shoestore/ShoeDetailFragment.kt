package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ListViewModel
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel
    private val listViewModel: ListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

//        binding?.apply {
//            viewModel = sharedViewModel
////            shoeDetailFragment = this@ShoeDetailFragment
//        }

        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.viewModel = shoeViewModel
        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener {
            if (!shoeViewModel.isEmpty()){
                listViewModel.addShoeList(shoeViewModel.listOfShoes())
                findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }else {
            Toast.makeText(context, "Please Enter Valid Data", Toast.LENGTH_LONG).show()
        }
        }

        return binding.root
    }
}