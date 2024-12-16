package com.example.app.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilledCardPlano(text: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFC0CB)
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
        )

      }
    }
}
@Composable
fun FourCards(){
    Column  (modifier = Modifier.padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PLANO DE PARTO",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        FilledCardPlano("TRABALHO DE PARTO")
        FilledCardPlano("DURANTE O PARTO")
        FilledCardPlano("APÓS O PARTO")
        FilledCardPlano("CUIDADOS COM O BEBÊ")
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewFourCardsExample() {
    FourCards() // Exibe os três cartões na interface de pré-visualização
}

