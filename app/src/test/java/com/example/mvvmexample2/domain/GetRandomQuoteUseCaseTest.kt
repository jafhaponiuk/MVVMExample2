package com.example.mvvmexample2.domain

import com.example.mvvmexample2.data.QuoteRepository
import com.example.mvvmexample2.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetRandomQuoteUseCaseTest {
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when database is empty then return null`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()

        //When
        val response = getRandomQuoteUseCase()

        //Then
        assert(response == null)
    }

    @Test
    fun `when database is not empty then return quote`() = runBlocking {
        //Given
        val quoteList = listOf(Quote("Hola", "José"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList

        //When
        val response = getRandomQuoteUseCase()

        //Then
        assert(response == quoteList.first())
    }
}