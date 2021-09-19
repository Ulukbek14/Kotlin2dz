package com.example.kotlin2dz.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2dz.databinding.ItemRecyclerBinding
import com.squareup.picasso.Picasso

class RecyclerAdapter():
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    lateinit var binding: ItemRecyclerBinding

    private var list: List<String> = ArrayList()

    fun addList(getList: List<String>) {
        list = getList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(string: String) {
            Picasso.get()
                .load(string)
                .resize(200, 200)
                .centerCrop()
                .into(binding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}