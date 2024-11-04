package com.test.yocoregister.ui.cashRegisterScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.yocoregister.ui.theme.GhostWhite
import com.test.yocoregister.ui.theme.YocoRegisterTheme

@Composable
fun ButtonSection(modifier: Modifier = Modifier, onButtonClick: (String) -> Unit) {

    val buttonNames = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "DEL", "0", "ADD")

    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center)
    {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(buttonNames) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.background(GhostWhite)
                ) {

                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(GhostWhite)
                            .clickable {
                                onButtonClick(it)
                            },
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonSectionPreview() {
    YocoRegisterTheme   {
        ButtonSection(onButtonClick = {})
    }
}