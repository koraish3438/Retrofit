package com.example.retrofit

import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getProduct(): List<ProductModel>
}
