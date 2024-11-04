package com.test.yocoregister.ui.common

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class CurrencyVisualTransformation(
    private val decimalDigits: Int = 2,
) : VisualTransformation {

    private val numberFormatSymbols: DecimalFormatSymbols = DecimalFormat().decimalFormatSymbols
    private val zeroDigitChar: Char = numberFormatSymbols.zeroDigit
    private val decimalSeparatorChar: Char = '.'
    override fun filter(text: AnnotatedString): TransformedText {
        val inputText = text.text

        val integerPart = inputText
            .dropLast(decimalDigits)
            .reversed()
            .chunked(3)
            .joinToString(" ")
            .reversed()
            .ifEmpty {
                zeroDigitChar.toString()
            }

        val fractionalPart = inputText.takeLast(decimalDigits).let { frac ->
            if (frac.length != decimalDigits) {
                List(decimalDigits - frac.length) {
                    zeroDigitChar
                }.joinToString("") + frac
            } else {
                frac
            }
        }

        val formattedText = if (decimalDigits == 0) {
            integerPart
        } else {
            "$integerPart$decimalSeparatorChar$fractionalPart"
        }

        val formattedAnnotatedString = AnnotatedString(
            text = formattedText,
            spanStyles = text.spanStyles,
            paragraphStyles = text.paragraphStyles
        )

        val offsetMapping = CursorEnabledOffsetMapping(
            originalTextLength = inputText.length,
            formattedTextLength = formattedText.length
        )
        return TransformedText(formattedAnnotatedString, offsetMapping)
    }

    private class CursorEnabledOffsetMapping(
        private val originalTextLength: Int,
        private val formattedTextLength: Int,
    ) : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int = formattedTextLength
        override fun transformedToOriginal(offset: Int): Int = originalTextLength
    }
}
