package com.example.coffeeshop.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeshop.Model.ItemsModel
import com.example.coffeeshop.databinding.ViewholderPopularBinding

class PopularAdapter(val items:MutableList<ItemsModel>) : RecyclerView.Adapter<PopularAdapter.Viewholder>() {

    private var context: Context? = null

    class Viewholder(val binding: ViewholderPopularBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)

    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

            holder.binding.titleTv.text = items[position].title
            holder.binding.priceTv.text = "$"+items[position].price.toString()
            holder.binding.popularRatingBar.rating = items[position].rating.toFloat()
            holder.binding.extraTv.text = items[position].extra




        Glide.with(holder.itemView.context)
            .load(items[position].imgUrl[0])
            .into(holder.binding.popularItemImg)

        holder.itemView.setOnClickListener {


        }

    }
}

