package com.example.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onClick:()-> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("HOME!")
        }
        Button(onClick = {
            onClick()
        }) {
            Text("Navega pro perfil!!!!")
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen {}
}