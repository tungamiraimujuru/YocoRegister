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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.yocoregister.ui.common.CurrencyVisualTransformation
import com.test.yocoregister.ui.theme.BrightGray
import com.test.yocoregister.ui.theme.Gunmetal
import com.test.yocoregister.ui.theme.YocoRegisterTheme

@Composable
fun TopSection(modifier: Modifier = Modifier, input: String) {

    Column(
        modifier = modifier.fillMaxSize()
            .background(BrightGray),
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                text = "R",
                modifier = Modifier.padding(end = 8.dp),
                fontSize = 40.sp, color = Gunmetal
            )

            BasicTextField(
                value = input,
                onValueChange = {},
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 40.sp,
                    color = Gunmetal,
                    textAlign = TextAlign.End
                ),
                visualTransformation = CurrencyVisualTransformation(),
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopSectionPreview() {
    YocoRegisterTheme   {
        TopSection(input = "0")
    }
}