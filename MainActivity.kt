package com.devkurdi.black

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// پۆڵێنا ڕەنگێن شین یێن پرۆفیشناڵ (Theme Colors)
val RoyalBlue = Color(0xFF0D47A1)
val AccentBlue = Color(0xFF1976D2)
val LightBlueBg = Color(0xFFF0F4C3) // ڕەنگێ پشت بنەما یێ ڕوون
val PureWhite = Color(0xFFFFFFFF)
val TextDark = Color(0xFF1A1A1A)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF4F6F9) // پاشبنەمایا گشتی یا شیناوەند
                ) {
                    BeautifulBlueApp()
                }
            }
        }
    }
}

@Composable
fun BeautifulBlueApp() {
    var xpCount by remember { mutableStateOf(100) }
    var currentScreenStatus by remember { mutableStateOf("بخێرهاتی بۆ پڕۆژەیێ فەرمی یێ BLACK") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // پشکا یەکێ: هێدەرێ سەرەکی یێ ئەپی (Main App Bar)
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = RoyalBlue),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "BLACK SYSTEM",
                        color = PureWhite,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "سیستمێ گەشەپێدانی ب زمانێ کاتلین",
                        color = PureWhite.copy(alpha = 0.8f),
                        fontSize = 14.sp
                    )
                }
            }
        }

        // پشکا دووێ: کارتا پێزانیان و ئامار ل سەر پڕۆژەی (Stats Card)
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = PureWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = "ئاستێ پڕۆژەی:", fontSize = 14.sp, color = Color.Gray)
                        Text(text = "پلا نەهێ (v1.0)", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(text = "خاڵێن ئەپی (XP):", fontSize = 14.sp, color = Color.Gray)
                        Text(text = "$xpCount XP", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = AccentBlue)
                    }
                }
            }
        }

        // پشکا سێیێ: کارتا بارودۆخی دینامیکی (Dynamic Status Message)
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = PureWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "نامەیا ژینگەها کارکرنێ:",
                        fontWeight = FontWeight.Bold,
                        color = RoyalBlue,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = currentScreenStatus,
                        color = TextDark,
                        fontSize = 16.sp
                    )
                }
            }
        }

        // پشکا چوارێ: دوگمەیێن شین یێن پرۆفیشناڵ بۆ کۆنترۆڵکرنێ
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // دوگمەیا مەزن یا شین (بۆ زێدەکرنا داتایان)
                Button(
                    onClick = {
                        xpCount += 50
                        currentScreenStatus = "داتا ب سەرکەفتیانە هاتە گۆڕین! خاڵ زێدە بوون 🚀"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = RoyalBlue)
                ) {
                    Text(text = "نووکرنا پێزانیانێن ئەپی", color = PureWhite, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                // دوگمەیا دووێ یا شینا ڕوون (بۆ پاککرنەوەی داتایان)
                Button(
                    onClick = {
                        xpCount = 100
                        currentScreenStatus = "سیستم دۆببارە هاتە ڕێکخستنەوە"
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AccentBlue)
                ) {
                    Text(text = "دوبارە دەستپێکرنەوە (Reset)", color = PureWhite, fontSize = 15.sp)
                }
            }
        }
    }
}
