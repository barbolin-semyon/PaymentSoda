package com.example.paymentsoda.ui.navigation

sealed class Screens(val route: String) {
    object ProductSelection : Screens("productSelection")
    object Cart : Screens("cart")
    object SelectAddress : Screens("selectAddress")
    object Payment : Screens("payment")
    object SelectedCard : Screens("selectedCard")
    object WitingForOTP : Screens("witingForOTP")
    object PaymentResult : Screens("paymentResult")
}
