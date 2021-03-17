package com.nelkinda.template.app.model

import lombok.Generated
import java.math.BigDecimal

data class Invoice(
        val total: BigDecimal,
        val salesTax10P: BigDecimal,
        val salesTax50P: BigDecimal,
        val envDeposit: BigDecimal
) {

    @Generated
    override fun equals(other: Any?) = this === other

    @Generated
    override fun hashCode() = super.hashCode()

}
