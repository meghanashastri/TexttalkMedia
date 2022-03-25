package com.example.texttalkmedia.data.repository

import android.util.Log
import com.example.texttalkmedia.data.model.NewsApiResponse
import com.example.texttalkmedia.data.repository.datasource.NewsLocalDataSource
import com.example.texttalkmedia.data.repository.datasource.NewsRemoteDataSource
import com.example.texttalkmedia.data.utils.Resource
import com.example.texttalkmedia.data.utils.networkBoundResource
import com.example.texttalkmedia.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    override fun getNews() = networkBoundResource(
        query = {
            newsLocalDataSource.getNews()
        },
        fetch = {
            responseToResource(newsRemoteDataSource.getNews())
        },
        saveFetchResult = { users ->
            users.data?.articles?.let { newsLocalDataSource.deleteAndInsertNews(it) }
        }
    )


    private fun responseToResource(response: Response<NewsApiResponse>): Resource<NewsApiResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

}