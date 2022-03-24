package com.example.texttalkmedia.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.texttalkmedia.domain.usecase.GetNewsUsecase

class NewsViewModel(
    private val getNews: GetNewsUsecase
) : ViewModel() {

    val news = getNews.execute().asLiveData()
}