package com.example.mvvmexample2.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmexample2.data.database.dao.QuoteDao
import com.example.mvvmexample2.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}