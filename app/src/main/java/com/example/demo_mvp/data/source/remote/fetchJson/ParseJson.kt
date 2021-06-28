package com.example.demo_mvp.data.source.remote.fetchJson

import android.util.Log
import com.example.demo_mvp.data.model.Book
import com.example.demo_mvp.data.model.BookEntry
import org.json.JSONObject

class ParseJson {
    fun bookParseJson(jsonObject: JSONObject) = jsonObject.getJSONObject(BookEntry.VOLUMEINFO).run {
        Book(
            getString(BookEntry.TITLE),
            getString(BookEntry.AUTHORS).toString(),
            getString(BookEntry.DESCRIPTION),
            getJSONObject(BookEntry.IMAGELINK).getString(BookEntry.URL_THUMBNAIL)
        )
    }

    fun parseJsonArray(jsonObject: JSONObject): MutableList<Book> {
        var data: MutableList<Book> = mutableListOf()
        jsonObject.getJSONArray(BookEntry.ITEMS).let { array ->
            for (item in 0 until array.length()) {
                data.add(bookParseJson(array.getJSONObject(item)))
            }
        }
        return data
    }
}