package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel() {

     val name = MutableLiveData<String>()
     val size = MutableLiveData<String>()
     val company = MutableLiveData<String>()
     val description = MutableLiveData<String>()


    fun isEmpty(): Boolean {
        val emptyName = name.value.isNullOrEmpty()
        val emptySize = size.value.isNullOrEmpty()
        val emptyComp = company.value.isNullOrEmpty()
        val emptyDs = description.value.isNullOrEmpty()

        return emptyName||emptySize||emptyComp||emptyDs
    }

    fun listOfShoes(): Shoe{
        return Shoe(name.value ?: "", size.value?.toDouble()!!,
            company.value ?: "", description.value ?: "", listOf(""))
    }


}