package com.moappdev.solutions.tronoapp

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("frase")
fun frase(text: TextView, quote: String){
    text.text= " '$quote'  "
}

@BindingAdapter("imagenBando")
fun imagen(img: ImageView, url: String){
    Glide.with(img.context)
        .load(url)
        .apply(RequestOptions()
            .placeholder(R.drawable.test)
            .error(R.drawable.test))
        .into(img)
}

