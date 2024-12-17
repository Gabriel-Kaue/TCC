package view.pages.vizualizarplano

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourCards(navController: NavHostController) {
    var trabalhoDeParto by remember { mutableStateOf("") }
    var duranteParto by remember { mutableStateOf("") }
    var aposParto by remember { mutableStateOf("") }
    var cuidadosComBebe by remember { mutableStateOf("") }


    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = "Voltar"
                    )
                }
            })
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
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

            //  Spacer para empurrar o botão para baixo.
            Spacer(modifier = Modifier.height(10.dp)) // Ajuste a
            Button(onClick = { }, modifier = Modifier.fillMaxWidth().height(64.dp)) {
                Text(text = "Salvar", textAlign = TextAlign.Center)
            }
        }
    }
}