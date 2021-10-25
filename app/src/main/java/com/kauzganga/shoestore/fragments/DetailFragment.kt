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
import com.kauzganga.shoestore.database.ShoeDatabase
import com.kauzganga.shoestore.databinding.FragmentDetailBinding
import com.kauzganga.shoestore.models.ShoeRepository
import com.kauzganga.shoestore.models.ShoeViewModel
import com.kauzganga.shoestore.models.ShoeViewModelFactory

class DetailFragment : Fragment() {
  // private val shoeViewModelX: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bindingOBj = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,R.layout.fragment_detail,container,false)

      val dao = ShoeDatabase.getInstance(requireContext().applicationContext).shoeDatabaseDao
      val repository = ShoeRepository(dao)
      val factory = ShoeViewModelFactory(repository)

      val viewModel = ViewModelProvider(requireActivity(), factory).get(ShoeViewModel::class.java)
        bindingOBj.saveShoe.setOnClickListener {
            viewModel.saveShoe()
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }
      bindingOBj.shoeViewModel = viewModel
            return bindingOBj.root
    }

}