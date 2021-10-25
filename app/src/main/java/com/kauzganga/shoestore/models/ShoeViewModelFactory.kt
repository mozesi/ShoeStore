package com.kauzganga.shoestore.models

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kauzganga.shoestore.database.ShoeDatabaseDao

class ShoeViewModelFactory (
    private val shoeRepository: ShoeRepository) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ShoeViewModel::class.java)) {
                return ShoeViewModel( shoeRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
