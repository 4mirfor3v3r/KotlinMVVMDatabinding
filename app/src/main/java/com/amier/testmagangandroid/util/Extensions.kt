package com.amier.kotlinmvvmgithubapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.amier.testmagangandroid.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


val picasso: Picasso
    get() = Picasso.get()

fun ImageView.load(path:String,request:(RequestCreator) ->RequestCreator){
    request(picasso
        .load(path)
        .placeholder(R.drawable.image_placeholder)
        .error(R.drawable.ic_sentiment_dissatisfied_black_24dp)
    )
        .into(this)
}

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView,url:String?){
    if (url!=null){
        view.load(url){requestCreator ->
            requestCreator.fit().centerCrop()
        }
    }
}

operator fun <T> MutableLiveData<ArrayList<T>>.plusAssign(values: List<T>) {
    val value = this.value ?: arrayListOf()
    value.addAll(values)
    this.value = value
}

