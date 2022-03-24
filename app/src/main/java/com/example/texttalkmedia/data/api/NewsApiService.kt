package com.example.texttalkmedia.data.api

import com.example.texttalkmedia.data.model.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {

    @GET("top-headlines?country=se&category=business&apiKey=4656d47976264161b5cb02f830b68308")
    suspend fun getNews(): Response<NewsApiResponse>
}