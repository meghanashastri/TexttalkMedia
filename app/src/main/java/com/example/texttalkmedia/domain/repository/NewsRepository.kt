package com.example.texttalkmedia.domain.repository

import com.example.texttalkmedia.data.model.Article
import com.example.texttalkmedia.data.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(): Flow<Resource<List<Article>>?>
}