package com.example.demo_mvp.data.source

import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.data.source.remote.OnFetchDataListener

interface BookDataSource {
    interface Remote{
        fun getBooksFromRemote(listener: OnFetchDataListener<MutableList<Book>>)
    }
}