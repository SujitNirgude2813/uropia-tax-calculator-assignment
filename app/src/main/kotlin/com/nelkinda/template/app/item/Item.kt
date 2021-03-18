package com.nelkinda.template.app.item

import com.nelkinda.template.app.currency.Currency
import com.nelkinda.template.app.deposit.Deposit
import com.nelkinda.template.app.salestax.SalesTax
import lombok.Generated
import java.math.BigDecimal

data class Item(
        val name: String,
        var count: Int,
        val price: Currency,
        val salesTax: SalesTax,
        val deposit: Deposit,
) {

    @Generated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (name != other.name) return false
        if (price != other.price) return false

        return true
    }

    @Generated
    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }

    fun getSalesTax(): Currency {
        return salesTax.calculateTax(price) * count
    }

    fun getDeposit(): Currency {
        return deposit.calculateDeposit(price) * count
    }

}
