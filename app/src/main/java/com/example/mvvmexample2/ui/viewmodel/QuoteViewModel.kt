package com.example.mvvmexample2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample2.data.model.QuoteModel
import com.example.mvvmexample2.data.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}