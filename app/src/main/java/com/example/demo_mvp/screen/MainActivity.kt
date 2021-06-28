package com.example.demo_mvp.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.demo_mvp.R
import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.data.source.BookRepository
import com.example.demo_mvp.screen.adapter.MainAdapter
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.View {

    private var adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
    }

    private fun initData() {
        val presenter = MainPresenter(BookRepository.instance)
        presenter.setView(this)
        presenter.start()
    }

    private fun initView() {
        val recyclerViewBook: RecyclerView = findViewById(R.id.recyclerviewBook)
        recyclerViewBook.setHasFixedSize(true)
        adapter.also { recyclerViewBook.adapter = it }
    }

    override fun getBooksSuccess(book: MutableList<Book>) {
        adapter.updateData(book)
    }

    override fun error(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_LONG).show()
    }
}