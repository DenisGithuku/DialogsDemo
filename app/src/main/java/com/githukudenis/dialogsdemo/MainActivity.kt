package com.githukudenis.dialogsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.githukudenis.dialogsdemo.ui.theme.DialogsDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialogsDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   SignInScreen(validationCode = "ExampleCode")
                }
            }
        }
    }
}
