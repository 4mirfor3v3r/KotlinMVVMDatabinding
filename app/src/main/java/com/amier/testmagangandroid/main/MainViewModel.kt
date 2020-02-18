package com.amier.testmagangandroid.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amier.testmagangandroid.api.NetworkConfig
import com.amier.testmagangandroid.model.MainData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(): ViewModel(){
    private var data = MutableLiveData<MainData>()
    private var status = MutableLiveData<Boolean>()
    private var mutableList = MutableLiveData<ArrayList<MainData>>()

    init {
        getData(){
            mutableList = it

        }
    }

    fun getData(callback: (MutableLiveData<ArrayList<MainData>>) ->Unit) {
        status.value = true
        NetworkConfig().api().data().enqueue(object : Callback<ArrayList<MainData>> {
            override fun onFailure(call: Call<ArrayList<MainData>>, t: Throwable) {
                status.value = true
                data.value = null
            }

            override fun onResponse(call: Call<ArrayList<MainData>>, response: Response<ArrayList<MainData>>) {
                status.value = false

                if (response.isSuccessful){
                    mutableList.value = response.body()
                    callback(mutableList)
                }
                else
                    status.value = true
            }
        })
    }
    fun setList():MutableLiveData<ArrayList<MainData>>{
        return mutableList
    }
}