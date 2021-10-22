package com.kauzganga.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bindingObj = DataBindingUtil.inflate<FragmentInstructionBinding>(inflater,R.layout.fragment_instruction,container,false)
        bindingObj.buttonShopping.setOnClickListener {
            findNavController().navigate(R.id.action_instructionFragment_to_listFragment)
        }
        bindingObj.fab.setOnClickListener {
            findNavController().navigate(R.id.action_instructionFragment_to_detailFragment)
        }
        return bindingObj.root
    }

}