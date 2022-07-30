package com.example.paymentsoda.ui.CartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.updateLiveLiteralValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.paymentsoda.ButtonProcessedForPayment
import com.example.paymentsoda.RechtangleWithBorder
import com.example.paymentsoda.data.Soda
import com.example.paymentsoda.data.allPrice
import com.example.paymentsoda.data.checkedProducts
import com.example.paymentsoda.data.sizeCheckedProducts
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.theme.Blue500
import com.example.paymentsoda.ui.theme.Gray200
import com.example.paymentsoda.ui.theme.Gray500

@Composable
fun CartScreen(navController: NavController) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ItemsCart()
        AmountView()
        ButtonProcessedForPayment {
            navController.navigate(Screens.SelectAddress.route)
        }
    }

}

@Composable
private fun AmountView() {
    RechtangleWithBorder(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(horizontal = 8.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Total Amount", style = MaterialTheme.typography.h5)
                Text("Inclusive of all taxes", style = MaterialTheme.typography.body1)
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f), horizontalArrangement = Arrangement.End
            ) {
                Text(
                    String.format("%.2f", allPrice.value).plus(" $"),
                    style = MaterialTheme.typography.h4
                )
            }
        }
    }
}
