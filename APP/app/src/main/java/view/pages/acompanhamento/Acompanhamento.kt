package view.pages.acompanhamento

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetoScreen(viewModel: FetoViewModel = viewModel(), navController: NavHostController = rememberNavController()) {
    val feto = viewModel.feto
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Voltar"
                    )
                }
            })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Nome: ${feto.nomeFeto}")
            Text(text = "Data de Nascimento: ${feto.dataNascimentoFeto}")
            Text(text = "Peso: ${feto.pesoFeto}")
            Text(text = "Altura: ${feto.alturaFeto}")
            Text(text = "Circunferência da Cabeça: ${feto.circunferenciaCabecaFeto}")
            Text(text = "Idade (meses): ${feto.idadeEmMesesFeto}")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.atualizarFeto() }) {
                Text(text = "Atualizar Dados")
            }
        }
    }
}