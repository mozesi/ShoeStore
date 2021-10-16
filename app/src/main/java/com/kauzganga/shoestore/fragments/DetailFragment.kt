package com.kauzganga.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.databinding.FragmentDetailBinding
import com.kauzganga.shoestore.models.ShoeViewModel

class DetailFragment : Fragment() {
  // private val shoeViewModelX: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bindingOBj = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,R.layout.fragment_detail,container,false)
        val shoeViewModelX = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        bindingOBj.shoeViewModel =shoeViewModelX
        bindingOBj.saveShoe.setOnClickListener {
            shoeViewModelX.saveShoe()
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }
            return bindingOBj.root
    }

}