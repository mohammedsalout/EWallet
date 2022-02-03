package com.mas.ewallet.uiItems.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mas.ewallet.data.moduel.UserItems
import com.mas.ewallet.databinding.ItemItemsBinding

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    private var data: ArrayList<UserItems> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding : ItemItemsBinding = ItemItemsBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        let {
            holder.bindView(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(list: List<UserItems>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(private var binding: ItemItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(userItems: UserItems) {
            binding.tvTitle.text = userItems.amount.toString()
        }

    }

}