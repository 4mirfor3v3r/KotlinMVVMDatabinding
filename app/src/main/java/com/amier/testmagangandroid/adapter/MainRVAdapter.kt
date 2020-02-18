package com.amier.testmagangandroid.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amier.testmagangandroid.R
import com.amier.testmagangandroid.databinding.ItemMainBinding
import com.amier.testmagangandroid.detail.DetailActivity
import com.amier.testmagangandroid.main.MainActionListener
import com.amier.testmagangandroid.model.MainData

class MainRVAdapter(val context: Context, private var list: ArrayList<MainData>): RecyclerView.Adapter<MainRVAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemMainRvBinding: ItemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_main,parent,false)
        return Holder(itemMainRvBinding)
    }

    class Holder(binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        private val repoItemBinding = binding
        fun bindRows(mainData: MainData, userActionListener: MainActionListener) {
            repoItemBinding.mainData = mainData
            repoItemBinding.action = userActionListener
            repoItemBinding.executePendingBindings()
        }
    }
    fun replaceData(repoD: ArrayList<MainData>) {
        setList(repoD)
    }
    private fun setList(repoD: ArrayList<MainData>) {
        this.list = repoD
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data =list[position]
        val actionListener = object : MainActionListener {
            override fun onClickItem() {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("data",data)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
            }
        }
        holder.bindRows(data, actionListener)
    }
}