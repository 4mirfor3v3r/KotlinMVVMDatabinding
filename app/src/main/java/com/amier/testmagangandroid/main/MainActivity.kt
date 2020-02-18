package com.amier.testmagangandroid.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amier.testmagangandroid.R

class MainActivity : AppCompatActivity() {

    lateinit var mActivity: MainActivity
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mActivity = this
    }
}
