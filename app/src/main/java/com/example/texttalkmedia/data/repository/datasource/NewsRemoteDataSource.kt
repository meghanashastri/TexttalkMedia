package com.example.texttalkmedia.data.repository.datasource

import com.example.texttalkmedia.data.model.NewsApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNews(): Response<NewsApiResponse>
}