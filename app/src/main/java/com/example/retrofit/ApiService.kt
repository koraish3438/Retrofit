package com.example.retrofit

import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProduct(): List<ProductModel>
}
