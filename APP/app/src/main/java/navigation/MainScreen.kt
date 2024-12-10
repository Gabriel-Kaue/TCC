package navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import view.HomeScreen
import view.pages.login.LoginForm
import view.pages.singup.SignupScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(navController = navController, startDestination = Routes.home) {
            composable(Routes.home) {
                HomeScreen(modifier = Modifier.padding(innerPadding), onLoginClick = {
                    navController.navigate(Routes.login)
                }, onSignupClick = {
                    navController.navigate(Routes.signup)
                })
            }
            composable(Routes.login) {
                LoginForm(navController) {

                }

            }
            composable(Routes.signup) {
                SignupScreen {

                }
            }
        }
    }
}
