package com.example.mvvmexample2.domain

import com.example.mvvmexample2.data.QuoteRepository
import com.example.mvvmexample2.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository) {
    // suspend operator fun invoke(): List<QuoteModel>? {
    //    return repository.getAllQuotes()
    //}

    // = function in comments
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}