package com.example.mvvmexample2.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmexample2.databinding.ActivityMainBinding
import com.example.mvvmexample2.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // "Observer { it: QuoteModel:" replaced by currentQuote for clarification->
        quoteViewModel.quoteModel.observe(this, Observer {currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        binding.viewCointainer.setOnClickListener { quoteViewModel.randomQuote()}
    }
}