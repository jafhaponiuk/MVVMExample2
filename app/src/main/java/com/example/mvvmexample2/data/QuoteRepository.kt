package com.example.mvvmexample2.data

import com.example.mvvmexample2.data.database.dao.QuoteDao
import com.example.mvvmexample2.data.database.entities.QuoteEntity
import com.example.mvvmexample2.data.model.QuoteModel
import com.example.mvvmexample2.data.network.QuoteService
import com.example.mvvmexample2.domain.model.Quote
import com.example.mvvmexample2.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}