package com.example.paymentsoda.ui.paymentResult

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentsoda.ui.navigation.Screens

@Composable
fun PaymentResultScreen(navController: NavController, code: String) {
    Text(text = code, fontSize = 32.sp)
}