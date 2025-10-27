package com.example.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewModel
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        // Adapter
        productAdapter = ProductAdapter(emptyList())
        binding.recyclerView.adapter = productAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe products
        productViewModel.products.observe(this) { products ->
            products?.let {
                productAdapter.updateProducts(it)
            }
        }

        // Refresh button
        binding.refreshBtn.setOnClickListener {
            productViewModel.refreshProducts()
        }
    }
}
