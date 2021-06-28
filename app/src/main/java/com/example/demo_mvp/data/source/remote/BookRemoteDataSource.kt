package com.example.demo_mvp.data.source.remote

import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.data.source.BookDataSource
import com.example.demo_mvp.data.source.remote.fetchJson.ParseDataWithJson
import com.example.demo_mvp.utils.Constant

class BookRemoteDataSource: BookDataSource.Remote {

    private object Holder{
        val INSTANCE = BookRemoteDataSource()
    }

    companion object{
        val instance: BookRemoteDataSource by lazy { Holder.INSTANCE }
    }

    override fun getBooksFromRemote(listener: OnFetchDataListener<MutableList<Book>>) {
        ParseDataWithJson(listener).execute(Constant.BASE_URL)
    }
}