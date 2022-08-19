package com.example.paymentsoda.ui.paymentResult

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentsoda.R
import com.example.paymentsoda.ui.Title
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.theme.Gray500
import com.example.paymentsoda.ui.theme.Red500
import com.example.paymentsoda.ui.theme.Teal500
import com.example.paymentsoda.ui.theme.White

@Composable
fun PaymentResultScreen(navController: NavController, code: String) {

    val codeIsCorrect = "1234" == code

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Title(
            h1 = "Payment Successfuly Done!",
            h2 = "Interactively expedite revolutionary ROI after bricks-and-clicks alignments.",
            styleH1 = MaterialTheme.typography.h5,
            paddingValues = PaddingValues(top = 32.dp)
        )

        val painterIdIcon = if (codeIsCorrect) R.drawable.ic_check_mark else R.drawable.ic_cross

        Card(Modifier.padding(top = 32.dp), elevation = 4.dp, shape = RoundedCornerShape(16.dp)) {
            Icon(
                painter = painterResource(id = painterIdIcon),
                contentDescription = "Is success",
                tint = if (codeIsCorrect) Teal500 else Red500,
                modifier = Modifier
                    .size(280.dp)
                    .padding(16.dp)
            )
        }

        Text(
            text = "\$30.49 Amount\n" +
                    "deducted from your card",
            fontSize = 24.sp,
            color = Gray500,
            modifier = Modifier.padding(top = 16.dp),
            textAlign = TextAlign.Center
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Declaration: ")
                }

                append("scale turnkey outsourcing after multidisciplinary leadership skills. Interactively engineer 24/7 paradigms vis-a-vis cross functional value. Conveniently streamline distinctive bandwidth through vertical imperatives. Progressively drive.")
            },
            color = Gray500,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )

        val textButton = if (codeIsCorrect) "Shop Again" else "Try Again"
        val routeOfNavigate =
            if (codeIsCorrect) Screens.ProductSelection.route else Screens.Payment.route


        Button(
            onClick = {
                navController.navigate(routeOfNavigate) {
                    popUpTo(navController.currentDestination!!.id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            border = BorderStroke(width = 1.dp, color = Gray500),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = White)
        ) {
            Text(text = textButton, Modifier.padding(vertical = 8.dp), fontWeight = FontWeight.Bold)
        }

    }


}