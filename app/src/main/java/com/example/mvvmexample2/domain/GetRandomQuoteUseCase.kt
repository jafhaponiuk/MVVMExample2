package com.example.mvvmexample2.domain

import com.example.mvvmexample2.data.model.QuoteModel
import com.example.mvvmexample2.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor() {

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}