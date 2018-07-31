package com.ratik.pizzakeeper.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ratik.pizzakeeper.R
import com.ratik.pizzakeeper.ui.creator.CreatorActivity

const val PIZZA_ID = "PIZZA_ID"

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.pizzaRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val launchCreatorActivity = { id: Int? ->
            val intent = Intent(this, CreatorActivity::class.java)
            intent.putExtra(PIZZA_ID, id)
            startActivity(intent)
        }
        val myAdapter = MainAdapter(launchCreatorActivity)
        recyclerView.adapter = myAdapter

        ViewModelProviders.of(this)
                .get(MainViewModel::class.java)
                .getPizzas()
                .observe(this, Observer {
                    if (it != null) {
                        myAdapter.list.clear()
                        myAdapter.list.addAll(it)
                        myAdapter.notifyDataSetChanged()
                    }
                })
    }
}

