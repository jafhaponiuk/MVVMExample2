package com.example.mvvmexample2.data

import com.example.mvvmexample2.data.model.QuoteModel
import com.example.mvvmexample2.data.model.QuoteProvider
import com.example.mvvmexample2.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService) {
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}