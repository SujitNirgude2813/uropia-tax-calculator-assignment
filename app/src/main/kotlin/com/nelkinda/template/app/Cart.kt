package com.nelkinda.template.app

class Cart {

    private var items = listOf<Item>()

    fun itemCount(): Int {
        return items.size
    }

    fun addItem(item: Item) {
        items = items + item
    }

}
