package com.example.paymentsoda.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Title(h1: String, h2: String = "") {
    Column {
        Text(
            text = h1,
            style = MaterialTheme.typography.h4,
            //fontSize = 24.sp,
        )

        Text(
            text = h2,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}