package com.amier.testmagangandroid.api

import com.amier.kotlinmvvmgithubapp.util.Constant
import com.amier.testmagangandroid.api.dao.MainDataDao
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("Gallery_Malang_Batu.json")
    fun getMainData(): Observable<MainDataDao>

    companion object Factory {

        fun create():ApiService{

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}