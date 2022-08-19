package com.example.paymentsoda.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Title(
    h1: String,
    h2: String = "",
    styleH1: TextStyle = MaterialTheme.typography.h4,
    paddingValues: PaddingValues = PaddingValues()
) {
    Column(Modifier.padding(paddingValues)) {
        Text(
            text = h1,
            style = styleH1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = h2,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}