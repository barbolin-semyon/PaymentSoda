package com.example.paymentsoda

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.paymentsoda.ui.navigation.MyNavHost
import com.example.paymentsoda.ui.navigation.Screens
import com.example.paymentsoda.ui.theme.Blue500
import com.example.paymentsoda.ui.theme.PaymentSodaTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentSodaTheme {
                val navController = rememberNavController()
                val title = remember { mutableStateOf("") }

                Scaffold(
                    topBar = {

                        val systemUI = rememberSystemUiController()
                        systemUI.isStatusBarVisible = false

                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Button(onClick = { navController.popBackStack() }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_back),
                                    contentDescription = "back"
                                )
                            }

                            if (title.value.isNotEmpty()) {

                                Text(
                                    text = title.value,
                                    modifier = Modifier.fillMaxWidth().weight(1f),
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center,

                                    )
                            }
                        }
                    }
                ) {
                    MyNavHost(navContoller = navController, title = title)
                }
            }
        }
    }
}
