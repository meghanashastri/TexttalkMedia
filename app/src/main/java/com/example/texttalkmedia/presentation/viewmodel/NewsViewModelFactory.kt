package com.example.texttalkmedia.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.texttalkmedia.domain.usecase.GetNewsUsecase

class NewsViewModelFactory(
    private val getNews: GetNewsUsecase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(
            getNews
        ) as T
    }
}