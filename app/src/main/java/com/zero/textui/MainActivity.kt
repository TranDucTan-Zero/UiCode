package com.zero.textui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zero.textui.ui.theme.TextUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Emails()
                }
            }
        }
    }
}

@Composable
fun Emails() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White, shape = RoundedCornerShape(40.dp))
                .padding(vertical = 5.dp) // Giảm padding dọc
                .verticalScroll(rememberScrollState())
        ) {
            EmailHeader()
            EmailContent()
            EmailFooter()
        }
    }
}
// text emails
@Composable
fun EmailHeader() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 30.dp)
            .fillMaxWidth()
    ) {
        ProfilePicture()
        Text("Emails", color = Color(0xFF141316), fontSize = 16.sp)
        Actions()
    }
}
//Menu
@Composable
fun ProfilePicture() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(color = Color(0xFFF1F5F9), shape = RoundedCornerShape(40.dp)),
    ) {
        // Box chứa các chấm
        Box(
            modifier = Modifier
                .size(40.dp)
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            // Sử dụng Column để sắp xếp các hàng chấm
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircleDot()
                    Spacer(modifier = Modifier.width(3.dp))
                    CircleDot()
                }
                Spacer(modifier = Modifier.height(3.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircleDot()
                    Spacer(modifier = Modifier.width(3.dp)) // Khoảng cách giữa các chấm
                    CircleDot()
                }
            }
        }
    }
}

@Composable
fun CircleDot() {
    Box(
        modifier = Modifier
            .size(5.22.dp) // Kích thước hình vuông
            .border(width = 0.88.dp, color = Color.Black, shape = RoundedCornerShape(1.75.dp)) // Viền đen và hình dạng của hình vuông
    )
}

// 3 chấm
@Composable
fun Actions() {
    Box(
        modifier = Modifier
            .size(40.dp) // Kích thước của hình tròn chứa các chấm
            .background(color = Color(0xFFF1F5F9), shape = RoundedCornerShape(20.dp)), // Nền hình tròn với màu nền
        contentAlignment = Alignment.Center
    ) {
        // Box chứa các chấm với padding
        Box(
            modifier = Modifier
                .size(30.dp) // Kích thước nhỏ hơn để tạo padding
                .padding(5.dp), // Padding giữa các chấm và viền nền
            contentAlignment = Alignment.Center
        ) {
            // Column chứa các chấm
            Column(
                verticalArrangement = Arrangement.SpaceEvenly, // Sắp xếp các chấm cách đều theo chiều dọc
                horizontalAlignment = Alignment.CenterHorizontally, // Căn giữa các chấm theo chiều ngang
                modifier = Modifier.fillMaxSize()
            ) {
                Dots()
                Dots()
                Dots()
            }
        }
    }
}

@Composable
fun Dots() {
    Box(
        modifier = Modifier
            .size(4.dp) // Kích thước của mỗi chấm
            .background(color = Color.Black, shape = RoundedCornerShape(6.dp)) // Chấm tròn với màu đen
    )
}

//Avatar  và te và nghe nghiep
@Composable
fun EmailContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(52.dp)
                .background(Color.Gray, shape = CircleShape)
        )
        Text(
            "Adom Shafi",
            color = Color(0xFF141316),
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 5.dp)
        )
        Text(
            "UX & UI Designer",
            color = Color(0xFF7E8494),
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
    RepeatEmails()
}

@Composable
fun RepeatEmails() {
    val emailContents = listOf(
        "Hello Mike. We are very happy to work with you...",
        "Hello Mike. We are very happy to work with you...",
        "Hello Mike. We are very happy to work with you...",
        "Hello Mike. We are very happy to work with you...",
        "Hello Mike. We are very happy to work with you...",
    )

    emailContents.forEach { content ->
        EmailRow(content)
    }
}
//List Mess
@Composable
fun EmailRow(content: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 3.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(color = Color(0xFFFF4EA1), shape = CircleShape)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("A", color = Color.White, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            // Email content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp)
                ) {
                    Text(
                        "Adom Shafi",
                        color = Color(0xFF7E8494),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(end = 8.dp) // Padding bên phải

                    )
                    Text("3", color = Color(0xFF7E8494), fontSize = 10.sp)
                    Spacer(modifier = Modifier.weight(0.5f))

                    Text(
                        "10 May",
                        color = Color(0xFF7E8494),
                        fontSize = 10.sp,

                    )
                }
                // Nội dung chính
                Text(
                    "UX & UI Design Collab",
                    color = Color(0xFF7E8494),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 0.dp)
                        .offset(y = (-9).dp)
                )
            }

        }
        // Nội dung mess
        Text(
            content,
            color = Color(0xFF7E8494),
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 45.dp, top = 4.dp)
                .offset(y = (-20).dp)
                .fillMaxWidth()
        )
    }
}
@Composable
fun EmailFooter() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .background(Color(0xFF4524DC), shape = RoundedCornerShape(50.dp))
            .padding(vertical = 4.dp)
    ) {
        FooterButton("Info")
        FooterButton("Images")
        FooterButton("Files")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .width(80.dp)
                .background(Color.White, shape = RoundedCornerShape(50.dp))
                .padding(vertical = 12.dp)
        ) {
            Text("Emails", color = Color(0xFF141316), fontSize = 14.sp)
        }
        FooterButton("Events")
    }
}

@Composable
fun FooterButton(text: String) {
    Text(
        text,
        color = Color.White,
        fontSize = 14.sp,
        modifier = Modifier.padding(end = 20.dp)
    )
}

