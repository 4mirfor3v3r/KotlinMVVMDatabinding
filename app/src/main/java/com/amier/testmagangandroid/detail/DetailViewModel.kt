package com.amier.testmagangandroid.detail

import com.amier.testmagangandroid.model.MainData
import java.util.*

class DetailViewModel(private val mainData: MainData) : Observable() {
    lateinit var data: MainData
    init {
        setData()
    }
    private fun setData() {
        data = mainData
    }
}