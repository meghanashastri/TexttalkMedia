package com.example.texttalkmedia.data.repository.datasourceImpl

import com.example.texttalkmedia.data.api.NewsApiService
import com.example.texttalkmedia.data.model.NewsApiResponse
import com.example.texttalkmedia.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService
) : NewsRemoteDataSource {
    override suspend fun getNews(): Response<NewsApiResponse> {
        return newsApiService.getNews()
    }
}