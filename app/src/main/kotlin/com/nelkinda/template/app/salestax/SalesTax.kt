package com.nelkinda.template.app.salestax

import com.nelkinda.template.app.currency.Currency


sealed class SalesTax {
    abstract fun calculateTax(price: Currency): Currency

    object NONE: SalesTax() {
        override fun calculateTax(price: Currency): Currency {
            return Currency.getDefault()
        }
    }

    object PERCENT_10: SalesTax() {
        override fun calculateTax(price: Currency): Currency {
            val percent = Currency.getDefault().setValue(10)
            return price.times(percent).div(Currency.getDefault().setValue(100))
        }
    }

    object PERCENT_50: SalesTax() {
        override fun calculateTax(price: Currency): Currency {
            val percent = Currency.getDefault().setValue(50)
            return price.times(percent).div(Currency.getDefault().setValue(100))
        }
    }
}
