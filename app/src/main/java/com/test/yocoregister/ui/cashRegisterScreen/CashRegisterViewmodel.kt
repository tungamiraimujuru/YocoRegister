package com.test.yocoregister.ui.cashRegisterScreen

import androidx.lifecycle.ViewModel
import com.test.yocoregister.ui.common.AmountCurrency
import com.test.yocoregister.ui.common.CurrencyUtil.decimalAmount
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class CashRegisterViewmodel : ViewModel() {

    private val _currentInputValue = MutableStateFlow("")
    val currentInputValue: StateFlow<String> = _currentInputValue

    private val _basket = MutableStateFlow<List<AmountCurrency>>(emptyList())
    val basket: StateFlow<List<AmountCurrency>> = _basket

    private val _displayError = MutableStateFlow(false)
    val displayError: StateFlow<Boolean> = _displayError

    //TODO refactor, i think the only cases i should cater for are the DEL and ADD buttons, the other instance can go into else
    fun onButtonClick(buttonLabel: String, inputValue: String) {
        when (buttonLabel) {
            "DEL" -> handleDelete()
            "ADD" -> handleAdd(inputValue)
            else -> {
                handleNumber(buttonLabel, inputValue)
            }
        }
    }

    // "1",
    // "2",
    // "3",
    // "4",
    // "5",
    // "6",
    // "7",
    // "8",
    // "9"

    fun handleAdd(inputValue: String) {
        val amountCurrency = AmountCurrency("R", decimalAmount(inputValue))
        _basket.value += amountCurrency
        _currentInputValue.value = ""

    }

    fun handleDelete() {
        _currentInputValue.value = _currentInputValue.value.dropLast(1)
    }

    fun handleNumber(number: String, inputValue: String) {

        if (inputValue.isNotBlank() && inputValue.length >= 8) {
            _displayError.value = true
            return
        }

        _currentInputValue.value += number
    }

    // TODO update the initial state to false
    fun resetError() {
        _displayError.value = false
    }
}