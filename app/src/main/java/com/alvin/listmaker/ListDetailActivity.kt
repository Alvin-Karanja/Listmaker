package com.alvin.listmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListDetailActivity : AppCompatActivity() {

    lateinit var addTaskButton: FloatingActionButton

    lateinit var listItemsRecyclerView : RecyclerView

    lateinit var list: TaskList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)
        // Added ? and !!
        list = (intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as TaskList?)!!
        title = list.name

        // Assign RecyclerView to the local variable
        listItemsRecyclerView = findViewById(R.id.list_items_recyclerview)
        // Assign the RecyclerView an Adapter, and pass in the list
        listItemsRecyclerView.adapter = ListItemsRecyclerViewAdapter(list)
        // Assign the RecyclerView a Layout Manager that uses a LinearLayoutManager to
        //handle the presentation.
        listItemsRecyclerView.layoutManager = LinearLayoutManager(this)

        addTaskButton = findViewById(R.id.add_task_button)
        addTaskButton.setOnClickListener {
            showCreateTaskDialog()
        }
    }
}