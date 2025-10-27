package com.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val _products = MutableLiveData<List<ProductModel>>()
    val products: LiveData<List<ProductModel>> get() = _products

    init {
        refreshProducts()
    }

    fun refreshProducts() {
        viewModelScope.launch {
            fetchProducts()
        }
    }

    private suspend fun fetchProducts() {
        try {
            val response = ApiClient.apiService.getProduct()
            _products.postValue(response)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
