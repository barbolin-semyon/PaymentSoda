package com.example.paymentsoda.ui.witingForOTP

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.paymentResult.CircleTimer
import com.example.paymentsoda.ui.paymentResult.TextViewCode
import com.example.paymentsoda.ui.theme.Alpha
import com.example.paymentsoda.ui.theme.Gray200
import com.example.paymentsoda.ui.theme.Gray500
import com.example.paymentsoda.ui.theme.White

@Composable
fun WitingForOTPScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextViewCode(
            sizeCode = 4,
            modifier = Modifier.padding(top = 64.dp),
            sizeField = 90.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            navController.currentBackStackEntry?.arguments?.putString("code", it)
            navController.navigate(Screens.PaymentResult.route)
        }
        val isReverse = remember { mutableStateOf(false) }
        val resendOTPisVisible = remember { mutableStateOf(true) }

        CircleTimer(isReverse = isReverse) {
            resendOTPisVisible.value = true
        }
        ButtonSendOTP(resendOtpIsVisible = resendOTPisVisible.value) {
            isReverse.value = isReverse.value.not()
            resendOTPisVisible.value = false
        }
    }
}

@Composable
fun ButtonSendOTP(resendOtpIsVisible: Boolean, onClick: () -> Unit,) {
    if (resendOtpIsVisible) {
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

@Composable
fun SpacerForButtonSendOTP() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
    )

}