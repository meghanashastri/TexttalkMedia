package com.example.texttalkmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.texttalkmedia.databinding.ActivityMainBinding
import com.example.texttalkmedia.presentation.adapter.NewsListAdapter
import com.example.texttalkmedia.presentation.viewmodel.NewsViewModel
import com.example.texttalkmedia.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory

    @Inject
    lateinit var newsListAdapter: NewsListAdapter
    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this, factory)
            .get(NewsViewModel::class.java)
    }
}