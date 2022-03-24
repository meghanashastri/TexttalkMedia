package com.example.texttalkmedia.presentation.di

import com.example.texttalkmedia.domain.repository.NewsRepository
import com.example.texttalkmedia.domain.usecase.GetNewsUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetUsersUseCase(
        newsRepository: NewsRepository
    ): GetNewsUsecase {
        return GetNewsUsecase(newsRepository)
    }
}