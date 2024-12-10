package view.pages.maingest

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import navigation.Routes
import view.pages.calendario.Calendario
import view.pages.perfil.Perfil
import view.pages.vizualizarpf.ThreeCards
import view.pages.vizualizarplano.FourCards
import view.pages.acompanhamento.Acompanhamento

@Composable
fun MainG() {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.maingest,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.maingest) {
                DashboardG(
                    modifier = Modifier.padding(innerPadding),
                    onPlanoPartoClick = {
                        navController.navigate(Routes.planoparto)
                    },
                    onPerguntasClick = {
                        navController.navigate(Routes.perguntas)
                    },
                    onAcompanhamentoClick = {
                        navController.navigate(Routes.acompanhamento)
                    },
                    onCalendarioClick = {
                        navController.navigate(Routes.calendario)
                    },
                    onPerfilClick = {
                        navController.navigate(Routes.perfil)
                    },
                )
            }
            composable(Routes.planoparto) {
                FourCards()
            }
            composable(Routes.perguntas) {
                ThreeCards()
            }
            composable(Routes.acompanhamento) {
                Acompanhamento()
            }
            composable(Routes.calendario) {
                Calendario()
            }
            composable(Routes.perfil) {
                Perfil()
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainGest() {
    MainG()
}