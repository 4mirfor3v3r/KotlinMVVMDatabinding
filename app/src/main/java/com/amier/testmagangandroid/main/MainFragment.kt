package com.amier.testmagangandroid.main


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.amier.testmagangandroid.R
import com.amier.testmagangandroid.adapter.MainRVAdapter
import com.amier.testmagangandroid.model.MainData
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    var list:ArrayList<MainData> = arrayListOf()
    private lateinit var viewModel: MainViewModel
    private lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        this.mContext = context!!
        rvRepo.layoutManager = GridLayoutManager(context,3)
        viewModel.setList().observe(viewLifecycleOwner, Observer {
            showRecycler(it)
        })
    }
    private fun showRecycler(listArray:ArrayList<MainData>){
        rvRepo.adapter = MainRVAdapter(mContext,listArray)
    }
}
