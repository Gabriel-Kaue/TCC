package view.pages.maingest

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardG(
    modifier: Modifier = Modifier,
    onPlanoPartoClick: () -> Unit,
    onPerguntasClick: () -> Unit,
    onAcompanhamentoClick: () -> Unit,
    onCalendarioClick: () -> Unit,
    onPerfilClick: () -> Unit
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { onPerfilClick() }) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle, contentDescription = "Pessoa"
                    )
                }
            }
            // Additional configurations
        )
    }, floatingActionButton = {
        LargeFloatingActionButton(
            onClick = { onCalendarioClick() },

            ) {
            Icon(Icons.Filled.CalendarMonth, contentDescription = "Calendario")
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { onPerguntasClick() },
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text("Perguntas Frequentes")
            }
            Spacer(modifier = Modifier.height(64.dp))
            Button(
                onClick = { onPlanoPartoClick() },
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text("Plano de Parto")
            }
            Spacer(modifier = Modifier.height(64.dp))
            Button(
                onClick = { onAcompanhamentoClick() },
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Text("Acompanhamento")
            }
        }
    }
}

@Preview
@Composable
fun PreviewDashboardG() {
    DashboardG(onPlanoPartoClick = {},
        onPerguntasClick = {},
        onAcompanhamentoClick = {},
        onCalendarioClick = {},
        onPerfilClick = {})
}