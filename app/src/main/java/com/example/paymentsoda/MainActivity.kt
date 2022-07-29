package com.example.paymentsoda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.paymentsoda.ui.navigation.MyNavHost
import com.example.paymentsoda.ui.theme.Blue500
import com.example.paymentsoda.ui.theme.PaymentSodaTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentSodaTheme {
                val navController = rememberNavController()

                Scaffold(
                    topBar = {

                        val systemUI = rememberSystemUiController()
                        systemUI.isStatusBarVisible = false

                        Button(onClick = { navController.popBackStack() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back),
                                contentDescription = "back"
                            )
                        }
                    }
                ) {
                    MyNavHost(navContoller = navController)

                }
            }
        }
    }
}
