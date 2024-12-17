package view.pages.maingest

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import navigation.Routes
import view.pages.acompanhamento.Acompanhamento
import view.pages.calendario.Calendario
import view.pages.perfil.Perfil
import view.pages.vizualizarpf.ThreeCards
import view.pages.vizualizarplano.FourCards



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
                        // Verifica se já está na tela de perfil para evitar navegação duplicada
                        if (navController.currentDestination?.route != Routes.perfil) {
                            navController.navigate(Routes.perfil)
                        }
                    },
                )
            }
            composable(Routes.planoparto) {
                FourCards(navController = navController)
            }
            composable(Routes.perguntas) {
                ThreeCards(navController = navController)
            }
            composable(Routes.acompanhamento){
                Acompanhamento(navController = navController)
            }

            composable(Routes.calendario) {
                Calendario(navController = navController)
            }
            composable(Routes.perfil) {
                Perfil(navController = navController, salvarOnClick = {
                    // Retorna ao Dashboard sem recriar a tela de login
                    navController.popBackStack(Routes.maingest, false)
                })
            }
        }
    }
    }
