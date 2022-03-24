package com.example.texttalkmedia.presentation.di

import com.example.texttalkmedia.domain.usecase.GetNewsUsecase
import com.example.texttalkmedia.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        getNewsUsecase: GetNewsUsecase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            getNewsUsecase
        )
    }
}