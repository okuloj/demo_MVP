package com.example.demo_mvp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.getImage(strUrl: String) {
    Glide.with(this.context.applicationContext)
        .load(strUrl)
        .into(this)
}