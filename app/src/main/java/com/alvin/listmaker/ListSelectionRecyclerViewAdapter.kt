package com.alvin.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListSelectionRecyclerViewAdapter(val lists: ArrayList<TaskList>, val clickListener: ListSelectionRecyclerViewClickListener) : RecyclerView.Adapter<ListSelectionViewHolder>() {

    interface ListSelectionRecyclerViewClickListener {
        fun listItemClicked(list: TaskList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {

        // LayoutInflater is a system utility used to instantiate (or "inflate") a
        // layout XML file into its corresponding View objects.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_selection_view_holder,
                parent,
                false)

        // A ListSelectionViewHolder object is created, passing in the view created from
        //the layout
        return ListSelectionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.listPosition.text = (position + 1).toString()
        holder.listTitle.text = lists.get(position).name
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    fun addList(list: TaskList) {
        // update the ArrayList with the new TaskList
        lists.add(list)

        notifyItemInserted(lists.size - 1)
    }
}