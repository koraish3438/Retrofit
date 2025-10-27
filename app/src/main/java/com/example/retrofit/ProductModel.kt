package com.example.retrofit

data class ProductModel(
    val image: String,
    val title: String,
    val price: Double,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)
