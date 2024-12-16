package view.pages.vizualizarplano

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FourCards() {
    var trabalhoDeParto by remember { mutableStateOf("") }
    var duranteParto by remember { mutableStateOf("") }
    var aposParto by remember { mutableStateOf("") }
    var cuidadosComBebe by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PLANO DE PARTO",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = trabalhoDeParto,
            onValueChange = { trabalhoDeParto = it },
            label = { Text("Trabalho de parto") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = duranteParto,
            onValueChange = { duranteParto = it },
            label = { Text("Durante o parto") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = aposParto,
            onValueChange = { aposParto = it },
            label = { Text("Após o parto") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = cuidadosComBebe,
            onValueChange = { cuidadosComBebe = it },
            label = { Text("Cuidados com o bebê") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Salvar", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFourCardsExample() {
    MaterialTheme {
        FourCards()
    }
}