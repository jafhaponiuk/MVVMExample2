package com.example.mvvmexample2.data.network

import com.example.mvvmexample2.core.RetrofitHelper
import com.example.mvvmexample2.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}