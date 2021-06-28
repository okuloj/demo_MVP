package com.example.demo_mvp.screen

import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.utils.BasePresenter
import java.lang.Exception

interface MainContract {

    interface View {
        fun getBooksSuccess(book: MutableList<Book>)
        fun error(exception: Exception?)
    }

    interface Presenter: BasePresenter<View> {
        fun getBooks()
    }
}