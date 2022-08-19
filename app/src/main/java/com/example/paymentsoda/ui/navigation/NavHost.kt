package com.example.paymentsoda.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paymentsoda.ui.CartScreen.CartScreen
import com.example.paymentsoda.ui.PaymentOptions.PaymentOptionsScreen
import com.example.paymentsoda.ui.paymentResult.PaymentResultScreen
import com.example.paymentsoda.ui.product_selection.ProductSelection
import com.example.paymentsoda.ui.select_address.SelectAddressScreen
import com.example.paymentsoda.ui.witingForOTP.WitingForOTPScreen

@Composable
fun MyNavHost(navContoller: NavHostController, title: MutableState<String>) {
    NavHost(navController = navContoller, startDestination = Screens.ProductSelection.route) {
        composable(Screens.ProductSelection.route) {
            title.value = Screens.ProductSelection.name
            ProductSelection(navContoller)
        }
        composable(Screens.Cart.route) {
            title.value = Screens.Cart.name
            CartScreen(navController = navContoller)
        }
        composable(Screens.SelectAddress.route) {
            title.value = Screens.SelectAddress.name
            SelectAddressScreen(navContoller)
        }
        composable(Screens.Payment.route) {
            title.value = Screens.Payment.name
            PaymentOptionsScreen(navController = navContoller)
        }
        composable(Screens.SelectedCard.route) {
            title.value = Screens.SelectedCard.name
        }
        composable(Screens.WitingForOTP.route) {
            title.value = Screens.WitingForOTP.name
            WitingForOTPScreen(navController = navContoller)
        }
        composable(Screens.PaymentResult.route) {
            title.value = Screens.PaymentResult.name
            var code = navContoller.previousBackStackEntry?.arguments?.getString("code")
            if (code == null) code = "3245"
            PaymentResultScreen(navController = navContoller, code = code!!)

        }
    }
}