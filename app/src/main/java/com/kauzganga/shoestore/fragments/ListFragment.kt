package com.kauzganga.shoestore.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.databinding.FragmentListBinding
import com.kauzganga.shoestore.models.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.shoe_item.view.*


class ListFragment : Fragment() {

    private val shoeViewModelX: ShoeViewModel by activityViewModels()

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
       val viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        viewModel.shoes.observe(viewLifecycleOwner, Observer{
        for (index in it.indices){
            val linearLayout = bindingObj.scrollLinear
            val  view = inflater.inflate(R.layout.shoe_item,linearLayout,false)
            view.shoe_name.text = it[index].name
            view.company_name.text = it[index].company
            view.shoe_size.text = it[index].size.toString()
            view.edit_description.text = it[index].description
            linearLayout.addView(view)
           }
        })
        bindingObj.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
        return bindingObj.root
    }

}