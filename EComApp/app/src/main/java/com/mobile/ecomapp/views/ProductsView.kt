package com.mobile.ecomapp.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.mobile.ecomapp.R
import com.mobile.ecomapp.models.Product
import com.mobile.ecomapp.views.adapters.ProductsAdapter
import kotlinx.android.synthetic.main.products_view.view.*

class ProductsView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    private lateinit var productsAdapter: ProductsAdapter

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // inflate the layout into "this" component
        inflater.inflate(R.layout.products_view, this)

        productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
        productsAdapter = ProductsAdapter()
        productsRecyclerView.adapter = productsAdapter

    }

    fun setData(products: List<Product>){
        productsAdapter.setProducts(products)

    }
}