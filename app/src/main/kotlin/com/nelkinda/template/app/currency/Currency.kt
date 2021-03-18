package com.nelkinda.template.app.currency

import com.nelkinda.template.app.currency.impl.BigDecimalCurrency
import java.math.BigDecimal

abstract class Currency {
    abstract fun getStringValue(): String
    abstract fun getBigDecimalValue(): BigDecimal

    abstract fun setValue(value: String): Currency
    abstract fun setValue(value: Int): Currency
    abstract fun setValue(value: Double): Currency
    abstract fun setValue(value: BigDecimal): Currency

    abstract operator fun plus(incCurrency: Currency): Currency
    abstract operator fun plusAssign(incCurrency: Currency)
    abstract operator fun div(divCurrency: Currency): Currency
    abstract operator fun divAssign(divCurrency: Currency)
    abstract operator fun times(multiCurrency: Currency): Currency
    abstract operator fun times(count: Int): Currency
    abstract operator fun timesAssign(multiCurrency: Currency)

    companion object {
        fun getDefault() = BigDecimalCurrency()
    }
}
