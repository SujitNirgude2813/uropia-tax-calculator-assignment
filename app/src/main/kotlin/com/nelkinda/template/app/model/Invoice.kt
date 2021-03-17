package com.nelkinda.template.app.model

import java.math.BigDecimal

data class Invoice(
        val total: BigDecimal,
        val salesTax10P: BigDecimal,
        val salesTax50P: BigDecimal,
        val envDeposit: BigDecimal
)
