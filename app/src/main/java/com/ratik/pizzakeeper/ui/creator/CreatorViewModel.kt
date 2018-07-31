package com.ratik.pizzakeeper.ui.creator

import android.arch.lifecycle.ViewModel
import com.ratik.pizzakeeper.data.Topping

class CreatorViewModel : ViewModel() {
    var pizzaName = "New Pizza"
    val switchStates = mutableMapOf<Topping, Boolean>()
}