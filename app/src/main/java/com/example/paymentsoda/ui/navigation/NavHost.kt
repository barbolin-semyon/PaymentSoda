package com.example.paymentsoda.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paymentsoda.ui.product_selection.ProductSelection

@Composable
fun MyNavHost(navContoller: NavHostController, title: MutableState<String>) {
    NavHost(navController = navContoller, startDestination = Screens.ProductSelection.route) {
        composable(Screens.ProductSelection.route) {
            title.value = Screens.ProductSelection.name
            ProductSelection(navContoller)
        }
        composable(Screens.Cart.route) {
            title.value = Screens.Cart.name
        }
        composable(Screens.SelectAddress.route) {
            title.value = Screens.SelectAddress.name
        }
        composable(Screens.Payment.route) {
            title.value = Screens.Payment.name
        }
        composable(Screens.SelectedCard.route) {
            title.value = Screens.SelectedCard.name
        }
        composable(Screens.WitingForOTP.route) {
            title.value = Screens.WitingForOTP.name
        }
        composable(Screens.PaymentResult.route) {
            title.value = Screens.PaymentResult.name
        }
    }
}