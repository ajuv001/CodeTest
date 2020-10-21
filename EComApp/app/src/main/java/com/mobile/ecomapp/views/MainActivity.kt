package com.mobile.ecomapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.ecomapp.R
import com.mobile.ecomapp.models.HomeData
import com.mobile.ecomapp.viewModels.MainViewModel
import com.mobile.ecomapp.viewModels.ViewModelFactory
import com.mobile.ecomapp.views.adapters.BannersAdapter
import com.synnapps.carouselview.CarouselView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var carousalView: CarouselView
    private  lateinit var productsView: ProductsView
    private  lateinit var bannerView: RecyclerView
    private  lateinit var bannerAdapter: BannersAdapter
    private lateinit var homeData: HomeData
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        carousalView = CarouselView(this, null)
        productsView = ProductsView(this)
        bannerView = RecyclerView(this)
        carousalView.setImageListener { position, imageView ->
            Glide.with(this).load(homeData.carousels[position].image).into(imageView);
        }
        carousalView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400)
        productsView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        bannerView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500)
        bannerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        bannerAdapter = BannersAdapter()
        bannerView.adapter = bannerAdapter

        observeForData()
        viewModel.generateData()
    }

    private fun observeForData(){
        viewModel.homeData.observe(this, Observer { populateData(it) })

    }

    private fun populateData(data: HomeData){
        this.homeData = data
        carousalView.pageCount = data.carousels.size

        productsView.setData(data.products)
        bannerAdapter.setData(data.banners)

        for(order in data.order){
            when(order){
                "carousel" -> home_root_layout.addView(carousalView)
                "products" -> home_root_layout.addView(productsView)
                "banner" -> home_root_layout.addView(bannerView)
            }
        }
    }
}