package cl.rutchandia.thesportsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.rutchandia.thesportsapp.presentation.screens.MainScreen

@Composable
fun CountryNav(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen() }
    }
}