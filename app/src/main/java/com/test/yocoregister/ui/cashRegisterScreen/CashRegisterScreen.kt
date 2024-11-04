package com.test.yocoregister.ui.cashRegisterScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.yocoregister.ui.theme.YocoRegisterTheme
import kotlinx.coroutines.launch

@Composable
fun CashRegister(modifier: Modifier = Modifier, viewModel: CashRegisterViewmodel = viewModel()) {

    val input by viewModel.currentInputValue.collectAsStateWithLifecycle()
    val basket by viewModel.basket.collectAsStateWithLifecycle()
    val displayError by viewModel.displayError.collectAsStateWithLifecycle()

    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(displayError) {
        if (displayError) {
                snackBarHostState.showSnackbar(
                    message = "You have entered an invalid amount",
                    actionLabel = "Dismiss",
                    withDismissAction = true,
                    duration = SnackbarDuration.Short
                )
                viewModel.resetError()
        }
    }

    Scaffold(Modifier.fillMaxSize(), snackbarHost = {
        SnackbarHost(snackBarHostState) { data ->
            Snackbar(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(data.visuals.message)
            }
        }
    }) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopSection(modifier = Modifier.weight(1f), input = input)

            ButtonSection(modifier = Modifier.weight(1f), onButtonClick = {
                viewModel.onButtonClick(it, input)
            })

            Bottom(modifier = Modifier.weight(1f), basket)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CashRegisterContentPreview() {
    YocoRegisterTheme {
        CashRegister(viewModel = viewModel())
    }
}