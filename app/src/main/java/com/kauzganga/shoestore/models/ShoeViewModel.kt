package com.kauzganga.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.fragments.DetailFragment
import kotlinx.coroutines.launch


class ShoeViewModel (private val shoeRepository: ShoeRepository) : ViewModel()  {
    val shoes  = shoeRepository.shoes

    val inPutName    = MutableLiveData<String>()
    val inPutSize    = MutableLiveData<String>()
    val inPutDescription = MutableLiveData<String>()
    val inPutCompany = MutableLiveData<String>()

    fun saveShoe(){
    val shoe = Shoe(0,"inPutSize.value!!.toString()","inPutName.value!!"
            ,":inPutCompany.value!!","inPutDescription.value!!")


    //Log.i("shoe",shoe.toString())
    insert(shoe)

    }

    private fun insert(shoe: Shoe){
        viewModelScope.launch {
           shoeRepository.insert(shoe)
        }
    }

}