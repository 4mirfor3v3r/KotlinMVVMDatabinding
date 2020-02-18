package com.amier.testmagangandroid.detail

import com.amier.testmagangandroid.model.MainData
import java.util.*

class DetailViewModel(val mainData: MainData) : Observable() {
    lateinit var data: MainData
    init {
        setData()
    }

    fun setData() {
        data = mainData
    }
}