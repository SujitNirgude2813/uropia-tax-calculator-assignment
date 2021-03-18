package com.nelkinda.template.app.deposit

import com.nelkinda.template.app.currency.Currency


sealed class Deposit {
    abstract fun calculateDeposit(price: Currency): Currency

    object NONE : Deposit() {
        override fun calculateDeposit(price: Currency): Currency {
            return Currency.getDefault()
        }
    }

    object PERCENT_40 : Deposit() {
        override fun calculateDeposit(price: Currency): Currency {
            val percent = Currency.getDefault().setValue(40)
            return price.times(percent).div(Currency.getDefault().setValue(100))
        }
    }

    object FIXED_0_5 : Deposit() {
        override fun calculateDeposit(price: Currency): Currency {
            return Currency.getDefault().setValue(0.5)
        }
    }
}

