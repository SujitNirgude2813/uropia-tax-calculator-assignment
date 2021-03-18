package com.nelkinda.template.app.item.impl

import com.nelkinda.template.app.currency.Currency
import com.nelkinda.template.app.deposit.Deposit
import com.nelkinda.template.app.item.Item
import com.nelkinda.template.app.item.ItemRepository
import com.nelkinda.template.app.salestax.SalesTax

class SampleItemRepository : ItemRepository {
    private val map = hashMapOf<String, ItemAdditionalCharges>()

    class ItemAdditionalCharges(
            val salesTax: SalesTax,
            val deposit: Deposit
    )

    init {
        map["Book/12.49"] = ItemAdditionalCharges(SalesTax.NONE, Deposit.NONE)
        map["Book/12.5"] = ItemAdditionalCharges(SalesTax.NONE, Deposit.NONE)
        map["Chocolate/2.25"] = ItemAdditionalCharges(SalesTax.PERCENT_50, Deposit.NONE)
        map["Wooden Chair/30.0"] = ItemAdditionalCharges(SalesTax.PERCENT_10, Deposit.NONE)
        map["Mobile Phone/130.0"] = ItemAdditionalCharges(SalesTax.NONE, Deposit.PERCENT_40)
        map["Coke/1.49"] = ItemAdditionalCharges(SalesTax.NONE, Deposit.FIXED_0_5)
        map["Oil Can/23.35"] = ItemAdditionalCharges(SalesTax.PERCENT_10, Deposit.FIXED_0_5)
        map["Tesla Car/40000.0"] = ItemAdditionalCharges(SalesTax.PERCENT_50, Deposit.PERCENT_40)
    }

    override fun getItem(name: String, quantity: Int, price: Double): Item? {
        val queryStr = "$name/$price"
        val additionalCharges = map[queryStr] ?: return null
        return Item(
                name,
                quantity,
                Currency.getDefault().setValue(price),
                additionalCharges.salesTax,
                additionalCharges.deposit
        )
    }

}
