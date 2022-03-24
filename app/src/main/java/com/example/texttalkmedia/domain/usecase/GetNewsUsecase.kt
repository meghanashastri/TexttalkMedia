package com.example.texttalkmedia.domain.usecase

import com.example.texttalkmedia.data.model.Article
import com.example.texttalkmedia.data.utils.Resource
import com.example.texttalkmedia.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUsecase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<Resource<List<Article>>?> {
        return newsRepository.getNews()
    }
}