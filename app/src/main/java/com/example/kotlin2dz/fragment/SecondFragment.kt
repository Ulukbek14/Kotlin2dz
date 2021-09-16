package com.example.kotlin2dz.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2dz.R
import com.example.kotlin2dz.adapter.RecyclerAdapter
import com.example.kotlin2dz.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val resAdapter = RecyclerAdapter()
    private  val viewModel: SecondViewModel by activityViewModels()
    private val binding by viewBinding(FragmentSecondBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupRequests()
    }

    private fun setupRequests() {
        viewModel.list.observe(viewLifecycleOwner,{
            Log.e("anime", it.toString())
            resAdapter.addList(it)
        })
    }

    private fun setupRecycler() {
        binding.recycler.apply {
            layoutManager = GridLayoutManager(requireContext(),3)
            adapter = resAdapter
        }
    }
}