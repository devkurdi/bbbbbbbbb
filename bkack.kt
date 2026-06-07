package com.devkurdi.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@Composable
fun AppScreen() {
    // ئەڤ گۆڕاوە (Variables) پێزانینێن ناڤی و نامێ دپارێزن
    var nameInput by remember { mutableStateOf("") }
    var greetingMessage by remember { mutableStateOf("بخێرهاتی بۆ ئەپێ خۆ یێ ئێکێ!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // ١. سەردێڕێ ئەپی
        Text(
            text = "گەشەپێدانی ئەپ ب کاتلین",
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        // ٢. جهێ نڤیسینا ناڤی
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("ناڤێ خۆ بنڤیسە") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ٣. دوگمەیا کلیککرنێ
        Button(
            onClick = {
                if (nameInput.isNotEmpty()) {
                    greetingMessage = "سڵاو $nameInput، ئەپێ تە یێ کاتلین ب سەرکەفتیانە کار دکەت! 🚀"
                } else {
                    greetingMessage = "هیڤییە سەرەتا ناڤێ خۆ بنڤیسە!"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("کلیک بکە")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // ٤. پەیاما ئەنجامی
        Text(
            text = greetingMessage,
            fontSize = 18.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
