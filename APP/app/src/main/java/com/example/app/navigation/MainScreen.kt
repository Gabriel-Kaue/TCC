package com.example.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.HomeScreen
import com.example.app.ProfileScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(navController = navController, startDestination = Routes.home) {
            composable(Routes.home){
                HomeScreen(Modifier.padding(innerPadding)) {
                    navController.navigate(Routes.profile)
                }
            }
            composable(Routes.profile) {
                ProfileScreen {
                    navController.popBackStack()
                }
            }
        }
    }




}