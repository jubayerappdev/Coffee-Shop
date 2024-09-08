package com.example.coffeeshop.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.Model.CategoryModel
import com.example.coffeeshop.R
import com.example.coffeeshop.databinding.ViewholderCategoryBinding

class CategoryAdapter (val items:MutableList<CategoryModel>): RecyclerView.Adapter<ViewHolder>(){

    private lateinit var context:Context
    private var selectedPosition=-1
    private var lastSelectedPosition=-1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.titleCat.text = item.title

        holder.binding.root.setOnClickListener{
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        if (selectedPosition==position){
            holder.binding.titleCat.setBackgroundResource(R.drawable.orange_bg)
        }else{
            holder.binding.titleCat.setBackgroundResource(R.drawable.edittext_bg)
        }
    }
}


class  ViewHolder(val binding: ViewholderCategoryBinding): RecyclerView.ViewHolder(binding.root)