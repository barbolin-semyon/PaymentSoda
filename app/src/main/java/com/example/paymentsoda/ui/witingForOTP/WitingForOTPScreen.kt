package com.example.paymentsoda.ui.witingForOTP

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.paymentResult.TextViewCode
import com.example.paymentsoda.ui.theme.Gray500
import com.example.paymentsoda.ui.theme.White

@Composable
fun WitingForOTPScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TitleCenter(
            "Waiting for the OTP",
            "Interactively expedite revolutionary ROI after briks-and-clicks alignments"
        )

        TextViewCode(
            sizeCode = 4,
            modifier = Modifier.padding(top = 32.dp),
            sizeField = 90.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            navController.currentBackStackEntry?.arguments?.putString("code", it)
            navController.navigate(Screens.PaymentResult.route)
        }

        val isReverse = remember { mutableStateOf(false) }
        val resendOTPisVisible = remember { mutableStateOf(true) }

        CircleTimer(isReverse = isReverse, padding = PaddingValues(top = 32.dp)) {
            resendOTPisVisible.value = true
        }
        ButtonSendOTP(
            resendOtpIsVisible = resendOTPisVisible.value,
            paddingValues = PaddingValues(top = 64.dp)
        ) {
            isReverse.value = isReverse.value.not()
            resendOTPisVisible.value = false
        }
    }
}

@Composable
fun TitleCenter(h1: String, h2: String) {
    Text(
        text = h1,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(top = 16.dp)
    )

    Text(
        text = h2,
        style = MaterialTheme.typography.body1,
        color = Gray500,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun ButtonSendOTP(resendOtpIsVisible: Boolean, paddingValues: PaddingValues, onClick: () -> Unit) {
    if (resendOtpIsVisible) {
        Column(Modifier.padding(paddingValues = paddingValues)) {
            SpacerForButtonSendOTP()

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Send OTP code",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 16.dp),
                    color = Gray500
                )
                Button(
                    onClick = { onClick() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = White,
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Gray)
                ) {
                    Text("Send", modifier = Modifier.padding(horizontal = 16.dp), color = Gray500)
                }
            }


            SpacerForButtonSendOTP()
        }
    }
}

@Composable
fun SpacerForButtonSendOTP() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
    )

}