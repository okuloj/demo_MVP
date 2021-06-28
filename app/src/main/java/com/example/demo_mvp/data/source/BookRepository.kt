package com.example.demo_mvp.data.source

import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.data.source.remote.BookRemoteDataSource
import com.example.demo_mvp.data.source.remote.OnFetchDataListener

class BookRepository private constructor(
    private val remote: BookDataSource.Remote) {

    private object Holder {
        val INSTANCE = BookRepository(BookRemoteDataSource.instance)
    }

    fun getBooks(listener: OnFetchDataListener<MutableList<Book>>) {
        remote.getBooksFromRemote(listener)
    }

    companion object {
        val instance: BookRepository by lazy { Holder.INSTANCE }
    }
}