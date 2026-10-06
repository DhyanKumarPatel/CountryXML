package com.example.sampletest.data.di

import com.example.sampletest.data.repository.CountryRepository
import com.example.sampletest.data.repository.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCountryRepository(repositoryImpl: CountryRepositoryImpl): CountryRepository
}