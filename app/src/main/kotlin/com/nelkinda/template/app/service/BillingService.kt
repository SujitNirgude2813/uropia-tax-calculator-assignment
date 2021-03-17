package com.nelkinda.template.app.service

import com.nelkinda.template.app.model.Cart
import com.nelkinda.template.app.model.Invoice
import java.math.BigDecimal

class BillingService {

    fun generateInvoice(cart: Cart): Invoice {
        return Invoice(BigDecimal(0.00))
    }

}
