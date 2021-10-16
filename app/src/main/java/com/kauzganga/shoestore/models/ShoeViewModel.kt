package com.kauzganga.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class ShoeViewModel : ViewModel() {

    val inPutName    = MutableLiveData<String>()
    val inPutSize    = MutableLiveData<String>()
    val inPutDescription = MutableLiveData<String>()
    val inPutCompany = MutableLiveData<String>()

    val _shoes = ArrayList<Shoe>()
    val shoes = MutableLiveData<List<Shoe>>()

    fun saveShoe(){
        val shoe = Shoe(inPutName.value!!,inPutSize.value!!.toDouble(),inPutCompany.value!!,inPutDescription.value!!)
        _shoes.add(shoe)
        shoes.value = _shoes
        Log.i("shoes",_shoes.size.toString())
    }

}