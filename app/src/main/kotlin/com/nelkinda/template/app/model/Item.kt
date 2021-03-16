package com.nelkinda.template.app.model

import java.math.BigDecimal

data class Item(
        val name: String,
        var count: Int,
        val price: BigDecimal
)
