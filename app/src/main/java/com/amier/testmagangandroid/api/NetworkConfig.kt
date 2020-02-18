package com.amier.testmagangandroid.api

import com.amier.testmagangandroid.util.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkConfig {
    private fun getInterceptor(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }
    private fun getNetwork(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun api():ApiService{
        return getNetwork().create(ApiService::class.java)
    }
}