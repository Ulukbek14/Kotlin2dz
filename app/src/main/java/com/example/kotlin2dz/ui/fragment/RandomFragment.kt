package com.example.kotlin2dz.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2dz.R
import com.example.kotlin2dz.ui.model.SecondViewModel
import com.example.kotlin2dz.databinding.FragmentRandomBinding
import com.example.kotlin2dz.utils.getEdText
import com.example.kotlin2dz.utils.loadImage
import com.squareup.picasso.Picasso
import kotlin.random.Random

class RandomFragment : Fragment(R.layout.fragment_random) {

    private val binding by viewBinding(FragmentRandomBinding::bind)
    private var photos: ArrayList<String> = ArrayList()
    private val viewModel: SecondViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        clickListener()
    }

    private fun clickListener() {
        binding.btnSubmit.setOnClickListener {
            val image = binding.etText.getEdText()
            photos.add(image)
            binding.etText.setText("")
        }

        binding.btnRandom.setOnClickListener {
            val random = Random.nextInt(photos.size)
            setImage(photos[random])
        }
    }

    private fun initView() {
        photos = arrayListOf(
            getString(R.string.godzilla),
            getString(R.string.mothra),
            getString(R.string.rodan),
            getString(R.string.kong),
            getString(R.string.ghidorah)
        )
        viewModel.list.value = photos
    }

    private fun setImage(url: String) {
        binding.ivUrl.loadImage(url)
    }
}