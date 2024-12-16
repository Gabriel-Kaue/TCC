package view.pages.perfil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Perfil(
    navController: NavController,
    salvarOnClick: () -> Unit
) {

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
    }, floatingActionButton = {
        LargeFloatingActionButton(onClick = {
            salvarOnClick()
        }) {
            Text("Salvar")
        }
    }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PersonalInformationForm()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInformationForm() {
    var name by remember { mutableStateOf("") }
    var nis by remember { mutableStateOf("") }
    var socialName by remember { mutableStateOf("") }
    var partnerName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var selectedRace by remember { mutableStateOf("") }
    var occupation by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    val raceOptions = listOf(
        "Branco",
        "Preto",
        "Amarelo",
        "Indigenous",
        "Pardo"
    )

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = nis,
            onValueChange = { nis = it },
            label = { Text("NIS") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = socialName,
            onValueChange = { socialName = it },
            label = { Text("Nome Social") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = partnerName,
            onValueChange = { partnerName = it },
            label = { Text("Nome do(a) Parceiro(a)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = dateOfBirth,
            onValueChange = { dateOfBirth = it },
            label = { Text("Data de Nascimento") },
            modifier = Modifier.fillMaxWidth()
        )

        // Race Dropdown
        var expanded by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = selectedRace,
                onValueChange = { },
                label = { Text("Raça") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                raceOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedRace = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }

        OutlinedTextField(
            value = occupation,
            onValueChange = { occupation = it },
            label = { Text("Ocupação") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Endereço") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

