package View.Navigation.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onLoginClick: () -> Unit, onSignupClick: () -> Unit) {
    Box(contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.padding(8.dp).align(Alignment.Center)
        ){
            Button(
                onClick = {
                    onLoginClick()
                          },
            ) {
                Text("LOGIN")
            }
            Button(
                onClick = {
                    onSignupClick()
                },
            ) {
                Text("CADASTRO")
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(onLoginClick = {}, onSignupClick = {})
}