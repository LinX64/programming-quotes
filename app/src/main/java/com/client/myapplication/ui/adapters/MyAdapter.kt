package com.client.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.client.myapplication.data.models.Quotes
import com.client.myapplication.data.models.QuotesItem
import com.client.myapplication.databinding.ListItemsBinding

class MyAdapter(
    private val myList: ArrayList<QuotesItem>
) : RecyclerView.Adapter<MyAdapter.DataViewHolder>() {

    inner class DataViewHolder(private val binding: ListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quotes: QuotesItem) {
            binding.list = quotes
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = myList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(myList[position])

}