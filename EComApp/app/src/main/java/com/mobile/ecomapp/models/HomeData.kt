package com.mobile.ecomapp.models

data class HomeData (
    val order: List<String>,
    val products: List<Product>,
    val carousels: List<Carousel>,
    val banners: List<Banner>
)