package com.nelkinda.template.app.unit

import com.nelkinda.template.app.Cart
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert.*

class CartSteps {

    private lateinit var cart: Cart

    @Given("An empty shopping cart")
    fun `An empty shopping cart`(){
        cart = Cart()
    }

    @Then("The item count of cart must be {int}")
    fun `The item count of cart must be`(count: Int){
        assertEquals(count,cart.itemCount())
    }
}
