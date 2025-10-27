package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ProductItemListBinding

class ProductAdapter(var products: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ProductItemListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ProductItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = products[position]
        holder.binding.productName.text = currentItem.title
        holder.binding.productPrice.text = "$${currentItem.price}"
        holder.binding.productRating.text = currentItem.rating.rate.toString()
        Glide.with(holder.binding.root.context)
            .load(currentItem.image)
            .into(holder.binding.productImage)
    }

    override fun getItemCount(): Int = products.size

    fun updateProducts(newProducts: List<ProductModel>) {
        products = newProducts
        notifyDataSetChanged()
    }
}
