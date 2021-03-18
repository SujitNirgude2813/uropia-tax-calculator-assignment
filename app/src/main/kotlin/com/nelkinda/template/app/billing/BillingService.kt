package com.nelkinda.template.app.billing

import com.nelkinda.template.app.cart.Cart
import com.nelkinda.template.app.salestax.SalesTax

class BillingService {

    fun generateInvoice(cart: Cart): Bill {
        val bill = Bill()

        cart.getItems().forEach {
            bill.total += it.price * it.count

            when (it.salesTax) {
                SalesTax.PERCENT_10 -> bill.salesTax10P += it.getSalesTax()
                SalesTax.PERCENT_50 -> bill.salesTax50P += it.getSalesTax()
            }

            bill.envDeposit += it.getDeposit()
        }

        return bill
    }
}
