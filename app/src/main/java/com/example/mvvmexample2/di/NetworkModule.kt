package com.example.mvvmexample2.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // Application scope
object NetworkModule {
}