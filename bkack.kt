package com.devkurdi.black

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// پێناسەکردنا ڕەنگێن شین یێن جوان
val DeepBlue = Color(0Header, 0xFF0D47A1)
val SkyBlue = Color(0xFF1976D2)
val LightBlueBg = Color(0xFFE3F2FD)
val DarkText = Color(0xFF212121)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = LightBlueBg
                ) {
                    MainDashboard()
                }
            }
        }
    }
}

@Composable
fun MainDashboard() {
    var clickCount by remember { mutableStateOf(0) }
    var currentStatus by remember { mutableStateOf("سیستم یێ ئامادەیە 🚀") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // لایێ سەرەوە یێ ئەپی (App Bar)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = DeepBlue)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BLACK APP",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "دیزاین ب کاتلین و ڕەنگێ شینێ شاهانە",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }

        // پشکا ناوەڕاست (Status Card)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "بارودۆخێ ئەپی:",
                    fontWeight = FontWeight.Bold,
                    color = DeepBlue,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = currentStatus,
                    color = DarkText,
                    fontSize = 18.sp
                )
            }
        }

        // پشکا ژمارەی لێدانێ (Counter Card)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = SkyBlue)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ژمارەیا کلیکان:",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "$clickCount",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // دوگمەیا سەرەکی یا شین و مەزن
        Button(
            onClick = {
                clickCount++
                currentStatus = "تە ب سەرکەفتیانە داتا نووکر! 🎉"
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DeepBlue)
        ) {
            Text(
                text = "کلیک بکە بۆ گۆڕینی داتایان",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // دوگمەیا دووێ بۆ ڕیستکرنێ
        OutlinedButton(
            onClick = {
                clickCount = 0
                currentStatus = "سیستم یێ ئامادەیە 🚀"
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = DeepBlue)
        ) {
            Text(text = "دوبارە دەستپێکرنەوە (Reset)", fontSize = 16.sp)
        }
    }
}
