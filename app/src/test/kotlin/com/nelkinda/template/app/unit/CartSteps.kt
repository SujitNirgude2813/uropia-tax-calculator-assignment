package com.nelkinda.template.app.unit

import com.nelkinda.template.app.model.Cart
import com.nelkinda.template.app.model.Item
import io.cucumber.datatable.DataTable
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert.assertEquals

class CartSteps {

    private lateinit var cart: Cart

    @Given("An empty shopping cart")
    fun `An empty shopping cart`() {
        cart = Cart()
    }

    @Then("The item count of cart must be {int}")
    fun `The item count of cart must be`(count: Int) {
        assertEquals(count, cart.itemCount())
    }

    @Given("A cart with following items")
    fun `A cart with following item`(dataTable: DataTable) {
        cart = Cart()

        for (entry: Map<String, String> in dataTable.asMaps()) {
            val item = Item(entry.get("Item")!!, entry.get("Count")!!.toInt(), entry.get("Price")!!.toBigDecimal())
            cart.addItem(item)
        }
    }
}
