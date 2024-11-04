package com.test.yocoregister.ui.cashRegisterScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.yocoregister.ui.common.AmountCurrency
import com.test.yocoregister.ui.theme.BlackCoral
import com.test.yocoregister.ui.theme.GhostWhite
import com.test.yocoregister.ui.theme.YocoRegisterTheme
import java.math.BigDecimal

@Composable
fun Bottom(modifier: Modifier = Modifier, basket: List<AmountCurrency>) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackCoral), verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(basket) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = it.currency, textAlign = TextAlign.End,
                        fontSize = 16.sp, color = GhostWhite
                    )
                    Text(
                        text = it.amount.toString(), textAlign = TextAlign.End,
                        fontSize = 16.sp, color = GhostWhite
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        HorizontalDivider(
            modifier = Modifier
                .background(GhostWhite)
                .height(2.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        Total(basket = basket)

    }
}

@Preview(showBackground = true)
@Composable
private fun BottomPreview() {
    YocoRegisterTheme {
        Bottom(
            basket = listOf(
                AmountCurrency("R", BigDecimal("20")),
                AmountCurrency("R", BigDecimal("30"))
            )
        )
    }
}