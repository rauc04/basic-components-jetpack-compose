package com.rchincaamal.basiccomponentsjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rchincaamal.basiccomponentsjetpackcompose.ui.theme.BasicComponentsJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComponents()
        }
    }
}

@Composable
fun BasicComponents() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var textFieldValue by remember { mutableStateOf("") }
        var textValue by remember { mutableStateOf("Application title") }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = textValue,
            style = TextStyle(
                color = Color.Green,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = {
                Text(text = "Enter your text here")
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Icon"
                )
            },
        )

        Button(onClick = {
            textValue = textFieldValue
        }) {
            Text(text = "Accept")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComponents()
}