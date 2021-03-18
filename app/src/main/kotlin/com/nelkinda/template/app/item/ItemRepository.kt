package com.nelkinda.template.app.item

interface ItemRepository {
    fun getItem(name: String, quantity: Int, price: Double): Item?
}
