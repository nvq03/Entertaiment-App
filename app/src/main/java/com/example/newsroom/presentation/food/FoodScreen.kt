package com.example.newsroom.presentation.food

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsroom.domain.model.Foods
import com.example.newsroom.domain.model.foodItems
import com.mkrdeveloper.lazyrowonclickexamplejetpack.screens.DetailScreen
import com.mkrdeveloper.lazyrowonclickexamplejetpack.screens.MainScreenFood


@Composable
fun FoodScreen(modifier: Modifier = Modifier, navController: NavController) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(route = "MainScreen") {
            MainScreenFood(foodItems, navController)
        }
        composable(
            route = "DetailScreen/{foodName}/{foodIngredients}/{foodImageId}",
            arguments = listOf(
                navArgument("foodName") { type = NavType.StringType },
                navArgument("foodIngredients") { type = NavType.StringType },
                navArgument("foodImageId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val foodName = backStackEntry.arguments?.getString("foodName")
            val foodIngredients = backStackEntry.arguments?.getString("foodIngredients")
            val foodImageId = backStackEntry.arguments?.getInt("foodImageId")

            if (foodName != null && foodIngredients != null && foodImageId != null) {
                val foodItem = Foods(
                    name = foodName,
                    ingredients = foodIngredients,
                    imageId = foodImageId
                )
                DetailScreen(
                    foodItem = foodItem,
                    onBackPressed = {
                        navController.popBackStack()
                    }
                )
            }
        }
        }
    }
@Composable
fun VideoScreen() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(route = "MainScreen") {
            MainScreenFood(foodItems, navController)
        }
        composable(
            route = "DetailScreen/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val itemIndex = backStackEntry.arguments?.getInt("index") ?: 0
            val selectedItem = foodItems[itemIndex]
            DetailScreen(
                foodItem = selectedItem,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun test() {
    VideoScreen()

}