package com.example.newsroom.util.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsroom.domain.model.BottomBarScreen
import com.example.newsroom.presentation.Login.LoginViewModel
import com.example.newsroom.presentation.Profile.ProfileScreen
import com.example.newsroom.presentation.article_screen.ArticleScreen
import com.example.newsroom.presentation.food.FoodScreen
import com.example.newsroom.presentation.news_screen.NewsScreen
import com.example.newsroom.presentation.news_screen.NewsScreenViewModel
import com.example.newsroom.presentation.food.VideoScreen

@Composable
fun MainNavGraph(navController: NavHostController) {

    val argKey = "web_url"
    val loginViewModel = remember { LoginViewModel() }

    NavHost(
        navController = navController,
        route = Graph.MAIN_SCREEN_PAGE,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {

            val viewModel: NewsScreenViewModel = hiltViewModel()
            NewsScreen(
                state = viewModel.state,
                onEvent = viewModel::onEvent,
                onReadFullStoryButtonClick = { url ->
                    navController.navigate("article_screen?$argKey=$url")
                }
            )

            }

        composable(route = BottomBarScreen.Foods.route) {
            FoodScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController, viewModel = loginViewModel)

        }
        composable(
            route = "article_screen?${argKey}={$argKey}",
            arguments = listOf(navArgument(argKey) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            ArticleScreen(
                url = backStackEntry.arguments?.getString(argKey),
                onBackPressed = { navController.navigateUp() }
            )
        }

    }
    }