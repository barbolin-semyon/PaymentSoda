package com.example.paymentsoda.ui.PaymentOptions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentsoda.ButtonProcessedForPayment
import com.example.paymentsoda.R
import com.example.paymentsoda.data.BankCard
import com.example.paymentsoda.data.getColorsForCard
import com.example.paymentsoda.data.testListAddress
import com.example.paymentsoda.data.testListCard
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.theme.*

@Composable
fun PaymentOptionsScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Your Saved Cards", modifier = Modifier.padding(16.dp))

        val selectedCard = remember { mutableStateOf(testListCard[0]) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                AddNewCardButton()
                ListSavedCards { selectedCard.value = it }
                SelectedCard(selectedCard.value)
            }

            ButtonProcessedForPayment {
                navController.navigate(Screens.SelectedCard.route)
            }
        }
    }
}

@Composable
private fun SelectedCard(selectedCard: BankCard) {
    Card(elevation = 8.dp, modifier = Modifier.padding(top = 64.dp)) {
        CardScreen(
            colorOne = Black,
            colorTwo = Gray500,
            fontSize = 30.sp,
            modifier = Modifier
                .width(360.dp)
                .height(210.dp),
            card = selectedCard
        )
    }
}

@Composable
private fun ListSavedCards(onClick: (card: BankCard) -> Unit) {
    LazyRow(Modifier.padding(top = 8.dp, start = 16.dp)) {

        items(testListCard) { card ->

            val colorsCard = getColorsForCard()

            CardScreen(
                colorOne = colorsCard.first,
                colorTwo = colorsCard.second,
                fontSize = 16.sp,
                modifier = Modifier
                    .width(260.dp)
                    .height(130.dp)
                    .padding(end = 16.dp)
                    .clickable { onClick(card) },
                card = card
            )
        }
    }
}

@Composable
private fun AddNewCardButton() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue200),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
        ) {
            Text(text = "Add New Card", color = White)
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "add card",
                tint = White,
                modifier = Modifier
                    .size(16.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}