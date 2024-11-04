package com.test.yocoregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.test.yocoregister.ui.cashRegisterScreen.CashRegister
import com.test.yocoregister.ui.theme.YocoRegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YocoRegisterTheme {
                CashRegister()
            }
        }
    }
}
