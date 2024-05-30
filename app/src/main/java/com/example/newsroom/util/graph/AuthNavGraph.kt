package com.example.newsroom.util.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.newsroom.presentation.Login.LoginScreen
import com.example.newsroom.presentation.Login.LoginViewModel
import com.example.newsroom.presentation.Signup.SingupScreen
import com.example.newsroom.presentation.Splash.SplashScreen

class LoginViewModelProvider {
    private var loginViewModel: LoginViewModel? = null

    fun getLoginViewModel(): LoginViewModel {
        if (loginViewModel == null) {
            loginViewModel = LoginViewModel()
        }
        return loginViewModel!!
    }
}

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    val loginViewModelProvider = LoginViewModelProvider()

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.SPLASH.route
    ) {
        composable(route = AuthScreen.SPLASH.route) {
            SplashScreen(navController = navController)
        }

        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController = navController, viewModel = loginViewModelProvider.getLoginViewModel())
        }

        composable(route = AuthScreen.SignUp.route) {
            SingupScreen(navController = navController,viewModel = loginViewModelProvider.getLoginViewModel())
        }
    }
}
sealed class AuthScreen(val route: String) {
    object SPLASH : AuthScreen(route = "Splash")
    object Login : AuthScreen(route = "Login")
    object SignUp : AuthScreen(route = "Signup")
}