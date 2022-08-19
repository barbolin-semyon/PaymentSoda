package com.example.paymentsoda.ui.witingForOTP

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paymentsoda.ui.theme.*

data class CircleTimerColor(
    val background: Color,
    val progress: Color,
    val text: Color
)

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CircleTimer(
    title: String = "Waiting for the OTP",
    size: Dp = 200.dp,
    padding: PaddingValues = PaddingValues(),
    colors: CircleTimerColor = CircleTimerColor(Teal200, Teal500, Gray500),
    fontSize: TextUnit = 18.sp,
    isReverse: MutableState<Boolean>,
    onTimerCompleted: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
            .padding(padding)
    ) {
        val sweepAngle by animateFloatAsState(
            targetValue = if (isReverse.value) 0f else 360f,
            animationSpec = tween(durationMillis = if (isReverse.value) 60000 else 1000),
            finishedListener = {
                if (it == 0f) {
                    onTimerCompleted()
                } else {
                    isReverse.value = true
                }
            }
        )

        Circle(
            size = size,
            colors = colors,
            sweepAngle = sweepAngle
        )

        Text(
            text = title,
            color = colors.text,
            modifier = Modifier
                .width(size / 2),
            fontSize = fontSize,
            textAlign = TextAlign.Center,
        )

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Circle(
    size: Dp = 200.dp,
    colors: CircleTimerColor = CircleTimerColor(Teal200, Teal500, Black),
    sweepAngle: Float,
) {
    Canvas(
        modifier = Modifier
            .size(size = size),
        contentDescription = "",
        onDraw = {

            val sizeProgress = this.size.width / 1.1f
            val topLeftProgress = this.size.width / 2 - (sizeProgress / 2)

            val sizeBackground = sizeProgress / 1.06f
            val topLeftBackground = this.size.width / 2 - (sizeBackground / 2)

            drawArc(
                color = colors.background,
                startAngle = 270f,
                sweepAngle = sweepAngle,
                useCenter = true,
            )

            drawArc(
                color = colors.progress,
                startAngle = 270f,
                sweepAngle = sweepAngle,
                useCenter = true,
                topLeft = Offset(topLeftProgress, topLeftProgress),
                size = Size(sizeProgress, sizeProgress)
            )



            drawOval(
                color = colors.background,
                topLeft = Offset(topLeftBackground, topLeftBackground),
                size = Size(sizeBackground, sizeBackground)
            )
        }
    )
}
