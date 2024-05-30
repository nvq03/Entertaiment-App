package com.example.newsroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.newsroom.presentation.news_screen.NewsScreen
import com.example.newsroom.presentation.news_screen.NewsScreenViewModel
import com.example.newsroom.presentation.theme.NewsroomTheme
import com.example.newsroom.util.graph.RootNavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsroomTheme {
                RootNavigationGraph()
            }
        }
    }
}
