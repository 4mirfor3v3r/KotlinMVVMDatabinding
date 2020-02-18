package com.amier.testmagangandroid.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amier.testmagangandroid.R
import com.amier.testmagangandroid.databinding.DetailFragmentBinding
import com.amier.testmagangandroid.model.MainData
import java.util.*

class DetailActivity : AppCompatActivity(), Observer {
    //    private val viewModel = DetailViewModel()
    private lateinit var detailViewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getParcelableExtra<MainData>("data")!!

//        if (savedInstanceState == null) { // During initial setup, plug in the details fragment.
//            val details = DetailFragment()
//            details.arguments = intent.extras
//            supportFragmentManager.beginTransaction().add(
//                R.id.detailFrame, details
//            ).commit()
//        }
        detailViewModel = DetailViewModel(data)
        initBinding()
    }
    fun initBinding(){
        val detailFragmentBinding: DetailFragmentBinding = DataBindingUtil.setContentView(this, R.layout.detail_fragment)
        detailFragmentBinding.vm = detailViewModel
        detailViewModel.addObserver(this)
    }

    override fun update(o: Observable?, arg: Any?) {
//        if (arg.toString() == )
    }
}