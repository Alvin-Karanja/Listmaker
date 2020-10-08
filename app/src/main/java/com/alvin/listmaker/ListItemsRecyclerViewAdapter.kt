package com.alvin.listmaker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListItemsRecyclerViewAdapter(var list: TaskList) : RecyclerView.Adapter<ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.tasks.size
    }
}