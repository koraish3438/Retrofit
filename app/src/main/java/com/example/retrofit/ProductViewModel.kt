package com.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.ApiClient.apiService
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _products = MutableLiveData<List<ProductModel>>()
    val products: LiveData<List<ProductModel>> get() = _products

    init {
        viewModelScope.launch {
            fetchProducts()
        }
    }
    private suspend fun fetchProducts() {
        try {
            val response = apiService.getProduct()
            _products.postValue(response)
        }
        catch (e: Exception) {
        }
    }

}