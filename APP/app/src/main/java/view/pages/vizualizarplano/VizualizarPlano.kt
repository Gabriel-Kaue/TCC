import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import room.AppDatabase
import view.pages.vizualizarplano.PlanoPartoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourCards(
    navController: NavHostController,
    database: AppDatabase,
    viewModel: PlanoPartoViewModel = viewModel { PlanoPartoViewModel(database) }
) {
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

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
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(scrollState),
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
                value = viewModel.trabalhoDeParto,
                onValueChange = { viewModel.updateTrabalhoDeParto(it) },
                label = { Text("Trabalho de parto") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.duranteParto,
                onValueChange = { viewModel.updateDuranteParto(it) },
                label = { Text("Durante o parto") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.aposParto,
                onValueChange = { viewModel.updateAposParto(it) },
                label = { Text("Após o parto") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.cuidadosComBebe,
                onValueChange = { viewModel.updateCuidadosComBebe(it) },
                label = { Text("Cuidados com o bebê") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    viewModel.salvarPlanoDeParto()
                    focusManager.clearFocus()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                Text(text = "Salvar", textAlign = TextAlign.Center)
            }
        }
    }
}