package com.amier.testmagangandroid.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amier.testmagangandroid.R
import com.amier.testmagangandroid.databinding.DetailFragmentBinding
import com.amier.testmagangandroid.model.MainData

class DetailActivity : AppCompatActivity() {
    private lateinit var detailViewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getParcelableExtra<MainData>("data")!!

        detailViewModel = DetailViewModel(data)
        initBinding()
    }
    private fun initBinding(){
        val detailFragmentBinding: DetailFragmentBinding = DataBindingUtil.setContentView(this, R.layout.detail_fragment)
        detailFragmentBinding.vm = detailViewModel
    }
}