package com.amier.testmagangandroid.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amier.testmagangandroid.adapter.MainRVAdapter
import com.amier.testmagangandroid.model.MainData

object MainBinding {
    @BindingAdapter("app:mainList")
    @JvmStatic
    fun setRepoList(recyclerView: RecyclerView, repoData: ArrayList<MainData>) {
        with(recyclerView.adapter as MainRVAdapter) {
            replaceData(repoData)
        }
    }
}