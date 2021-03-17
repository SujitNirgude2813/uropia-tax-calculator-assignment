package com.nelkinda.template.app.service

import com.nelkinda.template.app.model.Cart
import com.nelkinda.template.app.model.Invoice
import java.math.BigDecimal
import java.math.RoundingMode

class BillingService {

    fun generateInvoice(cart: Cart): Invoice {
        var total = BigDecimal(0).setScale(2, RoundingMode.HALF_UP)
        cart.getItems().forEach { total += it.price }

        return Invoice(total, BigDecimal(0.00), BigDecimal(0.00), BigDecimal(0.00))
    }

}
