package com.example.mvvmexample2.data.network

import com.example.mvvmexample2.data.model.QuoteModel
import retrofit2.http.GET
import retrofit2.Response

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}