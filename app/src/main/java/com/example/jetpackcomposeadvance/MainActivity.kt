package com.example.jetpackcomposeadvance

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeadvance.ui.theme.JetpackComposeAdvanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeAdvanceTheme {
                ProfileCardWithBox()
            }
        }
    }
}

@Composable
private fun SimpleButtonAndText() {
    var text by remember { mutableStateOf("changeable text...") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "profile image",
            modifier = Modifier.padding(8.dp)
        )
        Text(text = text)
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { text = "clicked button and change text" }) {
                Text(text = "change text")
            }
            Button(onClick = { text = "changeable text..." }) {
                Text(text = "reset text")
            }
        }
    }
}

@Composable
fun ProfileCard() {
    var message by remember { mutableStateOf("Welcome!") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // اضافه کردن یه تصویر (نیاز به یه فایل تصویر توی res/drawable داری)
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Profile Image",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "User Profile", modifier = Modifier.padding(8.dp), color = Color.Blue
        )
        Text(
            text = message, modifier = Modifier.padding(8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Button(onClick = { message = "Hello, User!" }) {
                Text("Greet")
            }
            Button(onClick = { message = "Welcome!" }) {
                Text("Reset")
            }
        }
    }
}
@Composable
fun ProfileCardWithBox() {
    var message by remember { mutableStateOf("Welcome!") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .padding(8.dp)
        ) {
            // تصویر (اگه داری)
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Profile Image",
            )
            // متن روی تصویر
            Text(
                text = "Overlay",
                color = Color.Red,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
        Text(
            text = "User Profile",
            modifier = Modifier.padding(8.dp),
            color = Color.Blue
        )
        Text(
            text = message,
            modifier = Modifier.padding(8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { message = "Hello, User!" }) {
                Text("Greet")
            }
            Button(onClick = { message = "Welcome!" }) {
                Text("Reset")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeAdvanceTheme {
        ProfileCardWithBox()
    }
}