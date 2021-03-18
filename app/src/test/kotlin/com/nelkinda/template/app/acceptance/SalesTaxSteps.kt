package com.nelkinda.template.app.acceptance

import com.nelkinda.template.app.billing.Bill
import com.nelkinda.template.app.billing.BillingService
import com.nelkinda.template.app.cart.Cart
import com.nelkinda.template.app.cart.CartService
import com.nelkinda.template.app.item.ItemDTO
import com.nelkinda.template.app.item.impl.SampleItemRepository
import io.cucumber.datatable.DataTable
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert.assertEquals

class SalesTaxSteps {

    private val cartService = CartService(SampleItemRepository())
    private val billingService = BillingService()

    private lateinit var cart: Cart
    private lateinit var bill: Bill

    @Given("the shopping cart contains the following items:")
    fun `the shopping cart contains the following items`(dataTable: DataTable) {
        val itemList = arrayListOf<ItemDTO>()
        for (entry: Map<String, String> in dataTable.asMaps()) {
            val item = ItemDTO(entry["Item"]!!, entry["Count"]!!.toInt(), entry["Price"]!!.toDouble())
            itemList.add(item)
        }

        cart = cartService.createCart(itemList)
    }

    @When("generating the bill")
    fun `generating the bill`() {
        bill = billingService.generateInvoice(cart)
    }

    @Then("the \"total\" MUST be {double}")
    fun `the total MUST be`(total: Double) {
        val result = String.format("%.2f", total)
        assertEquals(result, bill.total.getStringValue())
    }

    @And("the \"sales tax 10%\" MUST be {double}")
    fun `the sales tax 10P must be`(salesTax10P: Double) {
        val result = String.format("%.2f", salesTax10P)
        assertEquals(result, bill.salesTax10P.getStringValue())
    }

    @And("the \"sales tax 50%\" MUST be {double}")
    fun `the sales tax 50P must be`(salesTax50P: Double) {
        val result = String.format("%.2f", salesTax50P)
        assertEquals(result, bill.salesTax50P.getStringValue())
    }

    @And("the \"environmental deposit\" MUST be {double}")
    fun `the environmental deposit MUST be`(envDeposit: Double) {
        val result = String.format("%.2f", envDeposit)
        assertEquals(result, bill.envDeposit.getStringValue())
    }

}
