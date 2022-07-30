package com.example.paymentsoda.ui.CartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.paymentsoda.RechtangleWithBorder
import com.example.paymentsoda.data.Soda
import com.example.paymentsoda.data.allPrice
import com.example.paymentsoda.data.checkedProducts
import com.example.paymentsoda.ui.theme.Blue500
import com.example.paymentsoda.ui.theme.Gray200

@Composable
fun ItemsCart() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().height(400.dp).padding(top = 32.dp),
    ) {
        items(checkedProducts) { product ->
            val count = remember { mutableStateOf(1) }

            ItemCart(
                product = product,
                count = count.value,
                changeCount = { difference ->
                    allPrice.value += difference * product.price
                    count.value += difference
                }
            )
        }
    }
}

@Composable
private fun ItemCart(product: Soda, count: Int, changeCount: (difference: Int) -> Unit) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Gray200),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.imageId),
            contentDescription = product.title,
            modifier = Modifier.size(100.dp)
        )

        Column {
            Text(text = product.title, style = MaterialTheme.typography.h5)
            TextButton(onClick = {
                /*checkedProducts.remove(product)
                allPrice.value -= product.price * count
                sizeCheckedProducts.value -= 1*/
            }) {
                Text(text = "remove at cart", color = Blue500)
            }
        }

        TextWithRechtangleWithBorder("$count", Modifier.width(60.dp))
        TextWithRechtangleWithBorder("${product.price * count} $", Modifier.width(90.dp))

    }
}

@Composable
private fun TextWithRechtangleWithBorder(value: String, modifier: Modifier) {
    RechtangleWithBorder(modifier.fillMaxHeight()) {
        Text(text = value, fontWeight = FontWeight.Bold)
    }
}