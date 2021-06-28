package com.example.demo_mvp.screen.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.R
import com.example.demo_mvp.utils.getImage

class MainAdapter(): RecyclerView.Adapter<MainAdapter.ViewHolder?>() {

    private val books = mutableListOf<Book>()

    fun updateData(Books: MutableList<Book>?) {
        Books?.let {
            this.books.clear()
            this.books.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textViewTitle: TextView = itemView.findViewById(R.id.textTitle)
        private val textViewAuthor: TextView = itemView.findViewById(R.id.textAuthor)
        private val imageView: ImageView = itemView.findViewById(R.id.imageBook)
        fun bind(book: Book) {
            textViewTitle.text = book.title.toString()
            textViewAuthor.text = book.author.toString()
            imageView.getImage(book.urlThumbnail.toString())
        }
    }
}