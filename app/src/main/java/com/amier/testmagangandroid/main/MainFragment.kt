package com.amier.testmagangandroid.main


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amier.testmagangandroid.R
import com.amier.testmagangandroid.adapter.MainRVAdapter

import com.amier.testmagangandroid.databinding.FragmentMainBinding
import com.amier.testmagangandroid.model.MainData
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    var list:ArrayList<MainData> = arrayListOf()
    lateinit var mainD: MainData
    private lateinit var viewModel: MainViewModel
    lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mContext = context!!
        rvRepo.layoutManager = GridLayoutManager(context,3) as RecyclerView.LayoutManager?
//        rvRepo.layoutManager = StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL)
//        rvRepo.adapter = MainRVAdapter(mContext, dummy)
        viewModel.setList().observe(viewLifecycleOwner, Observer {
            showRecycler(it)
        })
    }
    fun showRecycler(listArray:ArrayList<MainData>){
        rvRepo.adapter = MainRVAdapter(mContext,listArray)
    }

//    DUMMY DATA
    val dummy:ArrayList<MainData> = arrayListOf(
        MainData("AKU",
            "https://images2.imgbox.com/52/1b/PMfvPUxo_o.jpg",
            "https://images2.imgbox.com/0a/e7/G421oy0Q_o.jpg"
        ),
        MainData("AKU2",
            "https://images2.imgbox.com/03/d7/dzXrbOuf_o.jpg",
            "https://images2.imgbox.com/f1/c5/Tv1L7t9B_o.jpg"
        ),
        MainData("AKU3",
            "https://images2.imgbox.com/3e/4d/p4ip6r31_o.jpg",
            "https://images2.imgbox.com/59/62/SXRaJdoU_o.jpg"
        )
    )
}
