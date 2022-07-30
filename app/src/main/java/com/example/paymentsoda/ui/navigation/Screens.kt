package com.example.paymentsoda.ui.navigation

sealed class Screens(val route: String, val name: String = "") {
    object ProductSelection : Screens("productSelection")
    object Cart : Screens("cart", "Cart")
    object SelectAddress : Screens("selectAddress", "Select your deliver address")
    object Payment : Screens("payment", "Select your payment options")
    object SelectedCard : Screens("selectedCard")
    object WitingForOTP : Screens("witingForOTP")
    object PaymentResult : Screens("paymentResult")
}
