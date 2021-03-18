package com.nelkinda.template.app.currency.impl

import com.nelkinda.template.app.currency.Currency
import java.math.BigDecimal
import java.math.RoundingMode

class BigDecimalCurrency: Currency() {

    private var value = BigDecimal(0)

    override fun getStringValue(): String {
        return value.setScale(2, RoundingMode.HALF_UP).toPlainString()
    }
    override fun getBigDecimalValue(): BigDecimal {
        return value.setScale(4, RoundingMode.HALF_UP)
    }

    override fun setValue(value: BigDecimal): Currency {
        value.setScale(4, RoundingMode.HALF_UP)
        this.value = value
        return this
    }
    override fun setValue(value: Int): Currency {
        this.value = value.toBigDecimal().setScale(4, RoundingMode.HALF_UP)
        return this
    }
    override fun setValue(value: Double): Currency {
        this.value = value.toBigDecimal().setScale(4, RoundingMode.HALF_UP)
        return this
    }
    override fun setValue(value: String): Currency {
        this.value = value.toBigDecimal().setScale(4, RoundingMode.HALF_UP)
        return this
    }

    override fun plus(incCurrency: Currency): Currency {
        return BigDecimalCurrency().setValue(value + incCurrency.getBigDecimalValue())
    }
    override fun plusAssign(incCurrency: Currency) {
        value += incCurrency.getBigDecimalValue()
    }

    override fun div(divCurrency: Currency): Currency {
        return BigDecimalCurrency().setValue(value / divCurrency.getBigDecimalValue())
    }
    override fun divAssign(divCurrency: Currency) {
        value /= divCurrency.getBigDecimalValue()
    }

    override fun times(multiCurrency: Currency): Currency {
        return BigDecimalCurrency().setValue(value * multiCurrency.getBigDecimalValue())
    }
    override fun times(count: Int): Currency {
        return BigDecimalCurrency().setValue(value * count.toBigDecimal())
    }
    override fun timesAssign(multiCurrency: Currency) {
        value *= multiCurrency.getBigDecimalValue()
    }

    override fun toString() = "Currency value = $value"
}
