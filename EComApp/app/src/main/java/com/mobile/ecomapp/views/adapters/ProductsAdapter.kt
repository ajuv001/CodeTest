package com.mobile.ecomapp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.ecomapp.R
import com.mobile.ecomapp.models.Product
import kotlinx.android.synthetic.main.product_layout.view.*

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>(){

    private var products: List<Product> = listOf()

    class ProductsViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {

        fun bind(product: Product) {
            Glide.with(mView.context).load(product.productImage).into(mView.imageView);
            mView.productNameTv.text = product.productName
            mView.offerTv.text = String.format(mView.context.getString(R.string.offer_text), product.productOffer)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.product_layout, parent, false)
        return ProductsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun setProducts(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }
}