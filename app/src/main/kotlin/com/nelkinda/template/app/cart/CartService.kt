package com.nelkinda.template.app.cart

import com.nelkinda.template.app.item.ItemDTO
import com.nelkinda.template.app.item.ItemRepository

class CartService(private val itemRepository: ItemRepository) {

    fun createCart(itemList: List<ItemDTO>): Cart {
        val cart = Cart()

        itemList.forEach {
            val item = itemRepository.getItem(it.name, it.count, it.price)
            if (item != null) {
                cart.addItem(item)
            }
        }

        return cart
    }
}
