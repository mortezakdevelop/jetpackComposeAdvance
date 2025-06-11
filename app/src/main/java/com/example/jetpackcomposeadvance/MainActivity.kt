package com.example.jetpackcomposeadvance

import android.os.Bundle
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeadvance.ui.theme.JetpackComposeAdvanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeAdvanceTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row {
                        MyTextField()
                        MyTextFieldThree()
                        ProfileCardWithBox()
                    }
                    //ProfileCardWithBox()

                }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCardWithBox() {
    var message by remember { mutableStateOf("Welcome!") }
    val textValue = remember { mutableStateOf("") }
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
                Text(text = stringResource(R.string.reset))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = ""
            )
            Text(text = "text with icon")
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = ""
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = ""
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            value = textValue.value,
            onValueChange = { textValue.value = it },
            label = {}
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    val valueTextTwo = remember { mutableStateOf("") }
    val primaryColor = colorResource(id = R.color.purple_500)
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        label = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(
                    id =
                    R.string.app_name
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = primaryColor,
            focusedLabelColor = primaryColor,
            cursorColor = primaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType
            = KeyboardType.Email
        ),
        value = valueTextTwo.value,
        onValueChange = {
            valueTextTwo.value = it
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldThree() {
    val textValue = remember { mutableStateOf("") }
    val primaryColor = colorResource(id = R.color.teal_200)
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        label = {
            Text(modifier = Modifier.fillMaxWidth(),
                text = stringResource(
                    id =
                    R.string.email
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = primaryColor,
            focusedLabelColor = primaryColor,
            cursorColor = primaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType
            = KeyboardType.Email
        ),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeAdvanceTheme {
        Row {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //ProfileCardWithBox()
                //MyTextField()
                MyTextField()
                MyTextFieldThree()
                ProfileCardWithBox()
            }
        }



    }
}