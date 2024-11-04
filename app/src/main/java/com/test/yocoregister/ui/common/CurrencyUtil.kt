package com.test.yocoregister.ui.common

import java.math.BigDecimal
import java.math.RoundingMode

object CurrencyUtil {

    fun decimalAmount(input: String): BigDecimal {
        return BigDecimal(input)
            .divide(BigDecimal(100), 2, RoundingMode.HALF_UP)
    }

    fun calculateTotal(basket: List<AmountCurrency>): BigDecimal {
        return basket.fold(BigDecimal.ZERO) { total, item ->
            total + item.amount
        }
    }
}