package com.nelkinda.template.app.billing

import com.nelkinda.template.app.currency.Currency
import lombok.Generated

data class Bill(
        val total: Currency = Currency.getDefault(),
        val salesTax10P: Currency = Currency.getDefault(),
        val salesTax50P: Currency = Currency.getDefault(),
        val envDeposit: Currency = Currency.getDefault()
) {

    @Generated
    override fun equals(other: Any?) = this === other

    @Generated
    override fun hashCode() = super.hashCode()

}
