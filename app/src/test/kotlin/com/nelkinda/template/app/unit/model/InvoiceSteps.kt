package com.nelkinda.template.app.unit.model

import com.nelkinda.template.app.model.Invoice
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import java.math.BigDecimal

class InvoiceSteps {

    private lateinit var invoice: Invoice

    @When("An invoice is generated with following values")
    fun `An invoice is generated with following values`(dataTable: List<Map<String, Double>>) {
        val map: Map<String, Double> = dataTable[0]
        invoice = Invoice(
                BigDecimal(map["Total"]!!),
                BigDecimal(map["Sales Tax 10%"]!!),
                BigDecimal(map["Sales Tax 50%"]!!),
                BigDecimal(map["Environmental Deposit"]!!)
        )
    }

    @Then("The invoice total is {double}")
    fun `The invoice total should be`(total: Double) {
        Assert.assertEquals(BigDecimal(total), invoice.total)
    }

    @And("The sales tax 10% is {double}")
    fun `The sales tax 10 percent should be`(salesTax10P: Double) {
        Assert.assertEquals(BigDecimal(salesTax10P), invoice.salesTax10P)
    }

    @And("The sales tax 50% is {double}")
    fun `The sales tax 50 percent should be`(salesTax50P: Double) {
        Assert.assertEquals(BigDecimal(salesTax50P), invoice.salesTax50P)
    }

    @And("The environmental deposit is {double}")
    fun `The environmental deposit should be`(envDeposit: Double) {
        Assert.assertEquals(BigDecimal(envDeposit), invoice.envDeposit)
    }

}
