package com.ratik.pizzakeeper.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(entities = [Pizza::class, PizzaTopping::class, Topping::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class PizzaDatabase: RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao
    abstract fun pizzaToppingDao(): PizzaToppingDao
    abstract fun toppingDao(): ToppingDao
}