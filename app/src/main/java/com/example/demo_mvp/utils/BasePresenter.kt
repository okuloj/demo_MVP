package com.example.demo_mvp.utils

interface BasePresenter<T>{
    fun start()
    fun setView(view: T?)
}