package com.amier.testmagangandroid.main


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.amier.testmagangandroid.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var viewbinding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e("BGT","OPENED")

        viewbinding = FragmentMainBinding.inflate(inflater,container,false).apply {

//            action = object :MainActionListener{
//                override fun onClickRepos(){
//                    vm?.openRepo()
//                }
//            }
        }
        return viewbinding.root
    }
}
