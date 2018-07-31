package com.ratik.pizzakeeper.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ratik.pizzakeeper.data.Pizza
import com.ratik.pizzakeeper.db

class MainViewModel: ViewModel() {
    private var pizzas: LiveData<List<Pizza>>? = null

    fun getPizzas(): LiveData<List<Pizza>> {
        if (pizzas == null) {
            return db.pizzaDao().getAll()
        }
        return pizzas!!
    }
}