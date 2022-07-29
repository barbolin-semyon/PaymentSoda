package com.example.paymentsoda.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paymentsoda.ui.product_selection.ProductSelection

@Composable
fun MyNavHost(navContoller: NavHostController) {
    NavHost(navController = navContoller, startDestination = Screens.ProductSelection.route) {
        composable(Screens.ProductSelection.route) { ProductSelection(navContoller) }
        composable(Screens.Cart.route) {}
        composable(Screens.SelectAddress.route) {}
        composable(Screens.Payment.route) {}
        composable(Screens.SelectedCard.route) {}
        composable(Screens.WitingForOTP.route) {}
        composable(Screens.PaymentResult.route) {}
    }
}