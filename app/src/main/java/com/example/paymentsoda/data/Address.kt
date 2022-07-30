package com.example.paymentsoda.data

import androidx.compose.runtime.mutableStateOf

data class Address(
    val text: String
)

val testListAddress = mutableStateOf(listOf(
    "649 Penn Street Retdfort, MI 48239",
    "649 Penn Street Retdfort, MI 48239",
    "649 Penn Street Retdfort, MI 48239",
    "649 Penn Street Retdfort, MI 48239",
    "649 Penn Street Retdfort, MI 48239",
))