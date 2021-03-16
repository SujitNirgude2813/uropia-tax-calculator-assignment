package com.nelkinda.template.app.model

class Cart {

    private var items = listOf<Item>()

    fun itemCount(): Int {
        return items.size
    }

    fun addItem(item: Item) {
        val existingItem = items.find { it == item }
        existingItem?.let {
            existingItem.count += item.count
            return
        }

        items = items + item
    }

    fun getItems(): List<Item> {
        return items
    }

}
