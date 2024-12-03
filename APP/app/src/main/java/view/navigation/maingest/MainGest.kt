package view.navigation.maingest

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import navigation.Routes
import view.navigation.login.LoginForm

@Composable
fun MainGest() {
    Scaffold { innerPadding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.maingest,
            modifier = Modifier.padding(innerPadding)
        ) {

        }
    }
}