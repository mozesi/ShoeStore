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
import com.kauzganga.shoestore.MainActivity
import com.kauzganga.shoestore.R
import com.kauzganga.shoestore.adapter.SleepNightAdapter
import com.kauzganga.shoestore.database.ShoeDatabase
import com.kauzganga.shoestore.databinding.FragmentListBinding
import com.kauzganga.shoestore.models.ShoeRepository
import com.kauzganga.shoestore.models.ShoeViewModel
import com.kauzganga.shoestore.models.ShoeViewModelFactory
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
        val dao = ShoeDatabase.getInstance(requireContext().applicationContext).shoeDatabaseDao
        val repository = ShoeRepository(dao)
        val factory = ShoeViewModelFactory(repository)

       val viewModel = ViewModelProvider(requireActivity(), factory).get(ShoeViewModel::class.java)

        val shoeAdapter = SleepNightAdapter()
        bindingObj.sleepList.adapter = shoeAdapter

            viewModel.shoes.observe(viewLifecycleOwner, Observer{
            shoeAdapter.shoes = it
        })
        bindingObj.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
        return bindingObj.root
    }

}