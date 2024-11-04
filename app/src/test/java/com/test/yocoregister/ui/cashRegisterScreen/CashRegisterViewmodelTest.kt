package com.test.yocoregister.ui.cashRegisterScreen

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CashRegisterViewmodelTest {

    private lateinit var viewModel: CashRegisterViewmodel

    @Before
    fun setUp() {
        viewModel = CashRegisterViewmodel()
    }

    @Test
    fun `given onButtonClick when buttonLabel is DEL then handleDelete is called `() = runBlocking {

        viewModel.handleNumber("5", "")

        viewModel.onButtonClick("DEL", viewModel.currentInputValue.first())

        assertEquals("", viewModel.currentInputValue.first())
    }

    @Test
    fun `given onButtonClick when buttonLabel is ADD then handleAdd is  called `() = runBlocking {

        viewModel.handleNumber("5", "")

        viewModel.onButtonClick("ADD", viewModel.currentInputValue.first())

        assertEquals(1, viewModel.basket.first().size)
        assertEquals("", viewModel.currentInputValue.first())
    }

    @Test
    fun `given handleAdd when Add button clicked then add item to basket and clear current input `() = runBlocking {

        viewModel.handleNumber("5", "")

        viewModel.handleAdd(viewModel.currentInputValue.first())

        assertEquals(1, viewModel.basket.first().size)
        assertEquals("", viewModel.currentInputValue.first())
    }

    @Test
    fun `given handleDelete when Delete button clicked remove last character from currentInputValue `() = runBlocking {

        viewModel.handleNumber("5", "")
        viewModel.handleNumber("3", "5")

        viewModel.handleDelete()

        assertEquals("5", viewModel.currentInputValue.first())
    }

    @Test
    fun `given handleNumber when length is less than 8 then we should append number `() = runBlocking {

        viewModel.handleNumber("1", "")

        viewModel.handleNumber("2", "1")

        assertEquals("12", viewModel.currentInputValue.first())
    }

    @Test
    fun `given handleNumber when input length is 8 or more then set displayError to true `() =
        runBlocking {

            viewModel.handleNumber("1", "12345678")

            assertTrue(viewModel.displayError.first())
            assertEquals("", viewModel.currentInputValue.first())
        }

    @Test
    fun `given resetError call then displayError to false`() = runBlocking {

        viewModel.handleNumber("1", "1234567")

        viewModel.resetError()

        assertFalse(viewModel.displayError.first())
    }
}