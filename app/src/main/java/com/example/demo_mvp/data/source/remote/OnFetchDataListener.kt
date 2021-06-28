package com.example.demo_mvp.data.source.remote

interface OnFetchDataListener<T> {
    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}