package com.example.paymentsoda.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.paymentsoda.R

data class Soda(
    val title: String,
    val imageId: Int,
    var price: Float = 5.3f
)

val sodaTestList = listOf(
    Soda("Coca-Cola", R.drawable.soda_1),
    Soda("Pepsi", R.drawable.soda_2),
    Soda("Shweps", R.drawable.soda_3),
    Soda("Buration", R.drawable.soda_4),
    Soda("Golden fruit jam", R.drawable.soda_1),
    Soda("Coca-Cola", R.drawable.soda_2),
    Soda("Pepsi", R.drawable.soda_3),
    Soda("Sprite", R.drawable.soda_4),
)

val checkedProducts =  mutableListOf<Soda>()
val sizeCheckedProducts = mutableStateOf(0)
val allPrice = mutableStateOf(0f)