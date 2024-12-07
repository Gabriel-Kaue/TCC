package view.navigation.vizualizarpf

import androidx.compose.foundation.layout.Column
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

// Parte Caio
@Composable
fun FilledCard(text: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFC0CB)
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
            .padding(8.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ThreeCards() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FAQ",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        FilledCard("Pergunta")
        FilledCard("Pergunta")
        FilledCard("Pergunta")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewThreeCardsExample() {
    ThreeCards() // Exibe os três cartões na interface de pré-visualização
}