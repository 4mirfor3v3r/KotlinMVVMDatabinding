package com.amier.testmagangandroid.api

import com.amier.testmagangandroid.model.MainData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("Gallery_Malang_Batu.json")
    fun data(): Call<ArrayList<MainData>>
}