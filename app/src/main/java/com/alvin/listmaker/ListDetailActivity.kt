package com.alvin.listmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
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

    private fun showCreateTaskDialog() {
        // Create an EditText so you can receive text input from the user
        val taskEditText = EditText(this)
        taskEditText.inputType = InputType.TYPE_CLASS_TEXT

        // Create an AlertDialogBuilder and use method chaining to set up various aspects
        //of the AlertDialog
        AlertDialog.Builder(this)
            .setTitle(R.string.task_to_add)
            .setView(taskEditText)
            .setPositiveButton(R.string.add_task) { dialog, _ ->

                // In the Positive Button’s click listener, you access the EditText to grab the text
                //input and create a task from the input
                val task = taskEditText.text.toString()
                list.tasks.add(task)

                // notify the ListItemsRecyclerViewAdapter that a new
                //item was added
                val recyclerAdapter = listItemsRecyclerView.adapter
                        as ListItemsRecyclerViewAdapter
                recyclerAdapter.notifyItemInserted(list.tasks.size-1)

                // close the dialog by dismissing it
                dialog.dismiss()
            }

            .create()
            .show()
    }
}