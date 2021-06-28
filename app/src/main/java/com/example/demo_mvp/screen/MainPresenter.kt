package com.example.demo_mvp.screen

import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.data.source.BookRepository
import com.example.demo_mvp.data.source.remote.OnFetchDataListener

class MainPresenter internal constructor(private val repository: BookRepository?): MainContract.Presenter{

    private var view: MainContract.View? = null

    override fun start() {
        getBooks()
    }

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getBooks() {
        repository?.getBooks(object : OnFetchDataListener<MutableList<Book>> {
            override fun onSuccess(data: MutableList<Book>) {
                view?.getBooksSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.error(exception)
            }
        })
    }
}