package com.example.paymentsoda.ui.product_selection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.paymentsoda.R
import com.example.paymentsoda.data.*
import com.example.paymentsoda.ui.Title
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.theme.*

@Composable
fun ProductSelection(navContoller: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ProductSelectionTitle()
        LazyRowProducts()
        InformationTable()
        AllPrice()
        ButtonPurchace(navContoller = navContoller)
    }
}

@Composable
private fun ButtonPurchace(navContoller: NavHostController) {
    Button(
        onClick = { navContoller.navigate(Screens.Cart.route) },
        colors = ButtonDefaults.buttonColors(backgroundColor = Red500),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(
            text = "Purchase now",
            color = White,
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)
        )
    }
}

@Composable
private fun AllPrice() {
    Text(
        text = "$${allPrice.value}",
        style = MaterialTheme.typography.h3,
        modifier = Modifier.padding(top = 36.dp)
    )
}


@Composable
private fun InformationTable() {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .background(color = Gray200, shape = RoundedCornerShape(32.dp))
            .padding(vertical = 24.dp, horizontal = 16.dp)
            .width(250.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Quantity", color = Color.Gray)

        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_bottle),
                contentDescription = "bottle",
                tint = Gray500,
                modifier = Modifier.size(20.dp)
            )

            Text("${sizeCheckedProducts.value} Bottle", color = Gray500)
        }
    }
}

@Composable
private fun LazyRowProducts() {

    LazyRow(modifier = Modifier.padding(top = 16.dp)) {
        items(sodaTestList) { product ->

            val check = remember { mutableStateOf(checkedProducts.contains(product)) }

            ItemProduct(
                product = product,
                isCheck = check.value,
                checked = {
                    if (check.value) {
                        checkedProducts.remove(product)
                        sizeCheckedProducts.value = sizeCheckedProducts.value - 1
                        allPrice.value = allPrice.value - product.price
                    } else {
                        checkedProducts.add(product)
                        sizeCheckedProducts.value = sizeCheckedProducts.value + 1
                        allPrice.value = allPrice.value + product.price
                    }
                    check.value = check.value.not()
                }


            )
        }
    }
}

@Composable
private fun ItemProduct(product: Soda, isCheck: Boolean, checked: () -> Unit) {

    val paddingTop = if (isCheck) 32.dp else 0.dp


    Row(
        Modifier
            .padding(top = paddingTop, start = 8.dp, end = 8.dp)
            .width(300.dp)
            .height(350.dp)
            .background(Gray200)
    ) {

        Image(
            painter = painterResource(id = product.imageId),
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )

        TextButton(onClick = { checked() }) {
            Icon(
                tint = if (isCheck) Teal500 else Gray500,
                painter = (painterResource(id = if (isCheck) R.drawable.ic_check_mark else R.drawable.ic_add)),
                contentDescription = "checked",
                modifier = Modifier.size(30.dp),

                )
        }
    }

}

@Composable
private fun ProductSelectionTitle() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Title(
            h1 = "Golden fruit jam",
            h2 = "100% Fruit extract jam with add sugar",
        )

        Icon(
            painter = painterResource(id = (R.drawable.ic_like_heart_round_icon)),
            contentDescription = "like",
            tint = Gray500,
            modifier = Modifier.size(30.dp)
        )
    }
}

