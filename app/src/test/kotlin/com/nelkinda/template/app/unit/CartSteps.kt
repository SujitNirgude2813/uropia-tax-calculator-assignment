package com.nelkinda.template.app.unit

import com.nelkinda.template.app.model.Cart
import com.nelkinda.template.app.model.Item
import io.cucumber.datatable.DataTable
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
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
            val item = Item(entry["Item"]!!, entry["Count"]!!.toInt(), entry["Price"]!!.toBigDecimal())
            cart.addItem(item)
        }
    }

    @When("Item with name as {string}, count as {int} and Price as {double} is added to cart")
    fun `Item is added to a cart`(name: String,count: Int, price: Double){
        val item = Item(name, count, price.toBigDecimal())
        cart.addItem(item)
    }

    @And("The quantity of this item should be {int}")
    fun `The quantity of item should be`(count: Int){
        assertEquals(count, cart.getItems()[0].count)
    }
}
