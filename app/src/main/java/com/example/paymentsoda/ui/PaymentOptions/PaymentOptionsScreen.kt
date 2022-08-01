package com.example.paymentsoda.ui.PaymentOptions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentsoda.data.colorsForCard
import com.example.paymentsoda.data.testListAddress
import com.example.paymentsoda.data.testListCard
import com.example.paymentsoda.ui.theme.*

@Composable
fun PaymentOptionsScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Your Saved Cards")

        LazyRow() {
            items(testListCard) { card ->

                val colorsCard = colorsForCard.random()

                CardScreen(
                    colorOne = colorsCard.first,
                    colorTwo = colorsCard.second,
                    modifier = Modifier
                        .width(260.dp)
                        .height(130.dp)
                        .padding(start = 16.dp),
                    card = card
                )
            }
        }
    }

}