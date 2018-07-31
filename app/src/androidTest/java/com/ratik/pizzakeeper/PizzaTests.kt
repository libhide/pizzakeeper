package com.ratik.pizzakeeper

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.ratik.pizzakeeper.data.Pizza
import com.ratik.pizzakeeper.data.PizzaDatabase
import com.ratik.pizzakeeper.data.PizzaTopping
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class PizzaTests {
    val appContext = InstrumentationRegistry.getTargetContext()
    val db = Room.databaseBuilder(appContext, PizzaDatabase::class.java,
            "PizzaDatabase").build()

    val testPizza = Pizza(0, "Hawaiian", Date())
    val testToppingIds = listOf(1, 7)

    @Test
    fun pizzaTest() {
        db.clearAllTables()

        db.pizzaDao().insert(testPizza)

        val returnedPizza = db.pizzaDao().getPizzaById(testPizza.id)
        assertEquals(testPizza, returnedPizza)
    }

    @Test
    fun pizzaToppingTest() {
        db.clearAllTables()

        db.pizzaDao().insert(testPizza)
        toppings.forEach {
            db.toppingDao().insert(it)
        }
        testToppingIds.forEach {
            val pizzaTopping = PizzaTopping(testPizza.id, it)
            db.pizzaToppingDao().insert(pizzaTopping)
        }

        val returnedToppingIds = db.pizzaToppingDao().getToppingIdsForPizzaId(testPizza.id)
        assertEquals(testToppingIds, returnedToppingIds)
    }
}
