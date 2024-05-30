package com.example.newsroom.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "news_screen",
        title = "Home",
        icon = Icons.Default.Home
    )


    object Foods : BottomBarScreen(
        route = "Food",
        title = "Foods",
        icon = Icons.Default.Favorite
    )

    object Profile : BottomBarScreen(
        route = "Profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
