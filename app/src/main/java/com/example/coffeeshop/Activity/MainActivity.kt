package com.example.coffeeshop.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeshop.Adapter.CategoryAdapter
import com.example.coffeeshop.R
import com.example.coffeeshop.ViewModel.MainViewModel
import com.example.coffeeshop.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initCategory()

    }

    private fun initCategory() {
        binding.categoryProgressBar.visibility = View.VISIBLE

        viewModel.category.observe(this, Observer {
            binding.categoryRv.layoutManager=
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            binding.categoryRv.adapter = CategoryAdapter(it)

            binding.categoryProgressBar.visibility = View.GONE
        })

        viewModel.loadCategory()
    }
}