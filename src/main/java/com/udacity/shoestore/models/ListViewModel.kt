package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList
    fun addShoeList(newShoe:Shoe){
        var list = mutableListOf(newShoe)
        if(_shoeList.value == null){
            _shoeList.value = list
        } else{
            _shoeList.value?.add(newShoe)

        }
    }
}