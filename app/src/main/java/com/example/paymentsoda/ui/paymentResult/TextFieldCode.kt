package com.example.paymentsoda.ui.paymentResult

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TextViewCode(
    sizeCode: Int,
    modifier: Modifier = Modifier,
    sizeField: Dp,
    shape: Shape,
    onWritedCode: (code: String) -> Unit,
) {
    val localFocusManager = LocalFocusManager.current

    val writeCode = remember { mutableStateOf(" ".repeat(sizeCode)) }

    Row(modifier = modifier) {
        repeat(sizeCode) { index ->
            OutlinedTextField(
                value = TextFieldValue(
                    text = writeCode.value[index].toString(),
                    selection = TextRange(writeCode.value.lastIndex)
                ),
                onValueChange = { newValue ->
                    if (newValue.text == "") {
                        if (index > 0) {
                            writeCode.value = writeCode.value.replaceIndex(index - 1, " ")
                            localFocusManager.moveFocus(FocusDirection.Left)
                        }
                    } else {
                        writeCode.value =
                            writeCode.value.replaceIndex(index, newValue.text.replace(" ", ""))

                        if (index + 1 < sizeCode) {
                            writeCode.value = writeCode.value.replaceIndex(index + 1, " ")
                            localFocusManager.moveFocus(FocusDirection.Right)
                        } else {
                            onWritedCode(writeCode.value)
                        }

                    }
                },
                keyboardActions = KeyboardActions(onPrevious = {
                    localFocusManager.moveFocus(
                        FocusDirection.Right
                    )

                }),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Previous
                ),
                shape = shape,
                modifier = Modifier
                    .size(sizeField)
                    .padding(8.dp)
            )
        }
    }
}

fun String.replaceIndex(index: Int, char: String): String {

    return if (index < this.lastIndex) {
        "${this.substring(0, index)}$char${this.substring(index + 1, this.length)}"
    } else {
        "${this.substring(0, index)}$char"
    }

}