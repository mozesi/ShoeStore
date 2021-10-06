package com.kauzganga.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.databinding.FragmentListBinding
import com.kauzganga.shoestore.models.ListViewModel


class ListFragment : Fragment() {

    private lateinit var listViewModel:ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bindingObj = DataBindingUtil.inflate<FragmentListBinding>(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )
        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        return bindingObj.root
    }

}