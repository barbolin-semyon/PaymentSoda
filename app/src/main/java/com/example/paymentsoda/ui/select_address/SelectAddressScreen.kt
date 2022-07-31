package com.example.paymentsoda.ui.select_address

import android.location.Address
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.paymentsoda.R
import com.example.paymentsoda.RechtangleWithBorder
import com.example.paymentsoda.data.testListAddress
import androidx.navigation.NavController as NavController1
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.paymentsoda.ButtonProcessedForPayment
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.theme.Black
import com.example.paymentsoda.ui.theme.Teal500
import com.example.paymentsoda.ui.theme.White


@Composable
fun SelectAddressScreen(navController: NavController1) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Interactively expedite revolutionary ROI after bricks-and-clicks alignments.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        )

        GridAddress()

        ButtonProcessedForPayment {
            navController.navigate(Screens.Payment.route)
        }
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun GridAddress() {

    val selectedAddress = remember { mutableStateOf("t") }

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        items(testListAddress.value) { address ->

            val isSelected = selectedAddress.value == address

            Item(
                isSelected = isSelected,

                clickable = {
                    selectedAddress.value = address
                },

                content = {
                    val textColor = if (isSelected) White else Black
                    Text(text = address, modifier = Modifier.padding(8.dp), color = textColor)
                })
        }

        item {
            Item(
                isSelected = false,
                clickable = {},
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "add",
                        Modifier.size(40.dp)
                    )

                    Text(text = "Add New Address", modifier = Modifier.padding(8.dp))
                }
            )
        }
    }
}

@Composable
private fun Item(isSelected: Boolean, clickable: () -> Unit, content: @Composable () -> Unit) {

    val backgroundColor = if (isSelected) Teal500 else White

    RechtangleWithBorder(
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .clickable { clickable() }
        ) {
            content()
        }
    }
}