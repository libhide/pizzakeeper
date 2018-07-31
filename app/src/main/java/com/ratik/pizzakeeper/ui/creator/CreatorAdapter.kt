package com.ratik.pizzakeeper.ui.creator

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import com.ratik.pizzakeeper.R
import com.ratik.pizzakeeper.data.Topping
import com.ratik.pizzakeeper.views.PizzaView

class CreatorAdapter(val pizzaView: PizzaView): RecyclerView.Adapter<CreatorAdapter.ViewHolder>() {
    val list = mutableListOf<Topping>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topping_row, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.updateView(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textView)
        val switch = view.findViewById<Switch>(R.id.toggle)

        fun updateView(index: Int) {
            val topping = list[index]

            switch.setOnCheckedChangeListener { button, isChecked ->
              pizzaView.toppings[topping] = isChecked
              pizzaView.invalidate()
            }

            textView.text = topping.name
        }
    }
}