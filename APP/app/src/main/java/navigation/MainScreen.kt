package navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import room.AppDatabase

import view.HomeScreen
import view.pages.acompanhamento.FetoScreen
import view.pages.login.LoginForm
import view.pages.maingest.DashboardG
import view.pages.perfil.Perfil
import view.pages.singup.SignupScreen
import view.pages.vizualizarpf.ThreeCards
import view.pages.vizualizarplano.FourCards
import view.pages.calendario.Calendario

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val database = remember {
        Room.databaseBuilder(context, AppDatabase::class.java, "tcc-db")
            .build()
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController, startDestination = Routes.home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.home) {
                HomeScreen(onLoginClick = {
                    navController.navigate(Routes.login)
                }, onSignupClick = {
                    navController.navigate(Routes.signup)
                })
            }
            composable(Routes.login) {
                LoginForm(navController) {
                    navController.navigate(Routes.maingest) {
                        popUpTo(Routes.home) { inclusive = true }
                    }
                }
            }
            composable(Routes.signup) {
                SignupScreen(navController) {
                    navController.navigate(Routes.maingest) {
                        popUpTo(Routes.home) { inclusive = true }
                    }
                }
            }
            composable(Routes.maingest) {
                DashboardG(
                    onPlanoPartoClick = { navController.navigate(Routes.planoparto) },
                    onPerguntasClick = { navController.navigate(Routes.perguntas) },
                    onAcompanhamentoClick = { navController.navigate(Routes.acompanhamento) },
                    onCalendarioClick = { navController.navigate(Routes.calendario) },
                    onPerfilClick = { navController.navigate(Routes.perfil) }
                )
            }
            composable(Routes.perfil) {
                Perfil(
                    navController = navController,
                    salvarOnClick = { navController.popBackStack() })
            }
            composable(Routes.planoparto) {
                FourCards(navController = navController, database = database)
            }
            composable(Routes.perguntas) {
                ThreeCards(navController = navController)
            }
            composable(Routes.acompanhamento){
                FetoScreen(navController = navController)
            }
            composable(Routes.calendario) {
                Calendario(navController = navController)
            }

        }
    }
}