package com.mobile.ecomapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.ecomapp.models.Banner
import com.mobile.ecomapp.models.Carousel
import com.mobile.ecomapp.models.HomeData
import com.mobile.ecomapp.models.Product
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    private val _homeLiveData = MutableLiveData<HomeData>()

    val homeData: LiveData<HomeData>
        get() = _homeLiveData

    fun generateData() {


        val banners = listOf(
            Banner("https://tinyurl.com/y379jw6s", "banner1"),
            Banner("https://tinyurl.com/y3pjtea4", "banner2"),
            Banner("https://tinyurl.com/y2gersqn", "banner3"),
            Banner("https://tinyurl.com/y3c6ksu5", "banner4"),
            Banner("https://tinyurl.com/y4k2klen", "banner5"),
            Banner("https://tinyurl.com/y3pccdrc", "banner6"),
            Banner("https://tinyurl.com/y26fn9rm", "banner7")
        )
        val carousels = listOf(
            Carousel("https://tinyurl.com/y3w8oaah", "Carousel1"),
            Carousel("https://tinyurl.com/y4vaulog", "Carousel2"),
            Carousel("https://tinyurl.com/y3j7rq6g", "Carousel3"),
            Carousel("https://tinyurl.com/y28jpmyr", "Carousel4"),
            Carousel("https://tinyurl.com/y2w7fbdo", "Carousel5"),
            Carousel("https://tinyurl.com/yy2f6lha", "Carousel6")
        )
        val products = listOf(
            Product("Black T-shirt", "https://tinyurl.com/y4f5e96j", "40"),
            Product("Red Shirt", "https://tinyurl.com/y2szwrys", "50"),
            Product("Blue T-shirt", "https://tinyurl.com/y4bfj5b7", "30"),
            Product("Purple Shirt", "https://tinyurl.com/y44marw5", "40"),
            Product("Yellow T-shirt", "https://tinyurl.com/y4urobx8", "30"),
            Product("Kurta", "https://tinyurl.com/y2yhf95n", "50"),
            Product("Black dress", "https://tinyurl.com/y5n467o3", "40"),
            Product("Saree", "https://tinyurl.com/yxupqdll", "20")
        )
        val order = listOf("carousel", "products", "banner")
        val homeData = HomeData(order, products, carousels, banners)
        _homeLiveData.postValue(homeData)
    }
}