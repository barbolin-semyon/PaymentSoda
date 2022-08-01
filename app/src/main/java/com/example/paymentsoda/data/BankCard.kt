package com.example.paymentsoda.data

import com.example.paymentsoda.ui.theme.*

data class BankCard(
    val date: String,
    val requisites: String,
    val nameMaster: String,
)

val testListCard = listOf(
    BankCard("10/2025", "2222", "Natasha Black"),
    BankCard("12/2023", "3333", "Ivan Krutko"),
    BankCard("10/2025", "4444", "Semen Barbolin"),
    BankCard("11/2023", "2222", "Vladimir Shikov "),
    BankCard("10/2025", "2222", "Natasha Black"),
)

val colorsForCard = listOf(
    Pair(Blue200, Blue500),
    Pair(Yellow200, Yellow500),
    Pair(Red200, Red500),
)