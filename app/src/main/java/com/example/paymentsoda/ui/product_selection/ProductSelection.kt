package com.example.paymentsoda.ui.product_selection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.paymentsoda.R
import com.example.paymentsoda.data.Soda
import com.example.paymentsoda.data.sodaTestList
import com.example.paymentsoda.ui.Title
import com.example.paymentsoda.ui.theme.Gray200
import com.example.paymentsoda.ui.theme.Gray500
import com.example.paymentsoda.ui.theme.Teal200
import com.example.paymentsoda.ui.theme.Teal500

@Composable
fun ProductSelection(navContoller: NavHostController) {
    Column {
        ProductSelectionTitle()


        val checkedProducts = remember { mutableListOf<Soda>() }

        LazyRow(modifier = Modifier.padding(top = 16.dp)) {
            items(sodaTestList) { product ->

                val check = remember { mutableStateOf(checkedProducts.contains(product))}

                ItemProduct(
                    product = product,
                    isCheck = check.value,
                    checked = {
                        if (check.value) {
                            checkedProducts.remove(product)
                        }else {
                            checkedProducts.add(product)
                        }
                        check.value = check.value.not()
                    }


                )
            }
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
            modifier = Modifier.fillMaxSize().weight(1f)
        )

        TextButton(onClick = { checked() } ) {
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

