package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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

        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        productAdapter = ProductAdapter(emptyList())

        binding.refreshBtn.setOnClickListener {
            val intent = Intent(this@ProductActivity, ProductActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.adapter = productAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        productViewModel.products.observe(this, Observer { products ->
            products?.let {
                productAdapter = ProductAdapter(it)
                binding.recyclerView.adapter = productAdapter
            }
        })
    }
}