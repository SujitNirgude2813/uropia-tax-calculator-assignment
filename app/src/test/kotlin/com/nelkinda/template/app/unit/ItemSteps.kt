package com.nelkinda.template.app.unit

import com.nelkinda.template.app.model.Item
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.*

class ItemSteps {

    private lateinit var item: Item

    @When("An item is created with name as {string}, quantity as {int}, unit price as {double}")
    fun `An item is created with`(name: String, count: Int, price: Double){
        item  = Item(name,count,price.toBigDecimal())
    }

    @Then("The name of Item should be {string}")
    fun `The name of item should be`(name: String){
        assertEquals(name, item.name)
    }

    @And("The count of Item should be {int}")
    fun `The count of Item should be`(count: Int){
        assertEquals(count, item.count)
    }

    @And("The price of Item should be {double}")
    fun `The price of Item should be`(price: Double){
        assertEquals(price.toBigDecimal(), item.price)
    }

}
