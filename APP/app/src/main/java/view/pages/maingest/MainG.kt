package view.pages.maingest

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import navigation.Routes

@Composable
fun MainG() {
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

@Preview
@Composable
fun PreviewMainGest() {
    MainG()
}