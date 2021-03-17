package com.nelkinda.template.app.unit.model

import com.nelkinda.template.app.model.Item
import io.cucumber.datatable.DataTable
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.*

class ItemSteps {

    private lateinit var item: Item
    private lateinit var item1: Item
    private lateinit var item2: Item

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

    @Given("Two item with name, quantity and price are as follows:")
    fun `Two item with name, quantity and price are`(dataTable: DataTable){
        val map1 = dataTable.asMaps()[0]
        item1 = Item(map1["Item"]!!, map1["Count"]!!.toInt(), map1["Price"]!!.toBigDecimal())

        val map2 = dataTable.asMaps()[1]
        item2 = Item(map2["Item"]!!, map2["Count"]!!.toInt(), map2["Price"]!!.toBigDecimal())
    }

    @Then("Both items should be equal")
    fun `Both item should be equal`(){
        assertEquals(item1,item2)
    }

    @Then("Both items should not be equal")
    fun `Both item should not be equal`(){
        assertNotEquals(item1,item2)
    }

}
