package com.test.yocoregister.ui.cashRegisterScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.yocoregister.ui.common.AmountCurrency
import com.test.yocoregister.ui.common.CurrencyUtil.calculateTotal
import com.test.yocoregister.ui.theme.GhostWhite
import com.test.yocoregister.ui.theme.YocoRegisterTheme
import java.math.BigDecimal

@Composable
fun Total(modifier: Modifier = Modifier, basket: List<AmountCurrency>) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {

        Text(
            text = "R",
            modifier = Modifier,
            textAlign = TextAlign.End,
            fontSize = 16.sp, color = GhostWhite
        )

        Text(
            text = calculateTotal(basket).toString(),
            modifier = Modifier,
            textAlign = TextAlign.End,
            fontSize = 16.sp, color = GhostWhite
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TotalPreview() {
    YocoRegisterTheme {
        Total(
            basket = listOf(
                AmountCurrency("R", BigDecimal("20")),
                AmountCurrency("R", BigDecimal("30"))
            )
        )
    }
}