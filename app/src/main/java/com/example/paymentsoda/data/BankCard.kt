package com.example.paymentsoda.data

import androidx.compose.ui.graphics.Color
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

private val colorsForCard = listOf(
    Pair(Red200, Red500),
    Pair(Blue200, Blue500),
    Pair(Yellow200, Yellow500),
)

private var indexColors = -1

fun getColorsForCard(): Pair<Color, Color> {
    indexColors = (indexColors + 1) % colorsForCard.size
    return colorsForCard[indexColors]
}