package com.nelkinda.template.app.cart

import com.nelkinda.template.app.item.Item

class Cart {

    private var items = listOf<Item>()

    fun addItem(item: Item) {
        val existingItem = items.find { it == item }
        existingItem?.let {
            existingItem.count += item.count
            return
        }

        items = items + item
    }

    fun getItems() = items

}
