package com.example.paymentsoda.ui.product_selection

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.paymentsoda.ui.navigation.Screens

@Composable
fun ProductSelection(navContoller: NavHostController) {
    Text(Screens.ProductSelection.route)
}