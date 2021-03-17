package com.nelkinda.template.app.unit.service

import com.nelkinda.template.app.model.Cart
import com.nelkinda.template.app.model.Invoice
import com.nelkinda.template.app.service.BillingService
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.*
import java.math.BigDecimal

class BillingServiceTest {

    private lateinit var cart: Cart
    private lateinit var invoice: Invoice

    @Given("An empty cart")
    fun `An empty cart`(){
        cart = Cart()
    }

    @When("The bill is generated")
    fun `The bill is generated`(){
        invoice = BillingService().generateInvoice(cart)
    }

    @Then("The invoice total should be {double}")
    fun `The invoice total should be`(total: Double){
        assertEquals(BigDecimal(total), invoice.total)
    }
}
