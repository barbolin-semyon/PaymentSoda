package com.example.paymentsoda.ui.PaymentOptions

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import android.graphics.Path.FillType
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.unit.dp
import com.example.paymentsoda.ui.theme.Red200
import com.example.paymentsoda.ui.theme.Red500
import com.example.paymentsoda.ui.theme.White
import kotlin.random.Random

@Composable
fun CardScreen(colorOne: Color, colorTwo: Color, modifier: Modifier) {
    Box(modifier = modifier) {
        BackgroundForCard(colorOne = colorOne, colorTwo = colorTwo)
        Text(text = "dfsfgdgdf", color = White)
    }
}

@Composable
private fun BackgroundForCard(colorOne: Color, colorTwo: Color) {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {

        drawPath(
            path = Path().apply {
                fillType = PathFillType.EvenOdd
                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
            },
            color = colorOne
        )

        drawPath(
            path = Path().apply {
                fillType = PathFillType.EvenOdd
                moveTo(0f, size.height)

                val twoRand = Random.nextInt(4, 6)

                cubicTo(size.width / 2, size.height / 2, size.width / twoRand, size.height / twoRand, size.width, 0f)
                lineTo(0f, 0f)
            },
            color = colorTwo
        )
    })
}