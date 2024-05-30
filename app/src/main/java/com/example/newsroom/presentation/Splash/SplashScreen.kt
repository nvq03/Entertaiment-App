package com.example.newsroom.presentation.Splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsroom.R
import com.example.newsroom.util.graph.AuthScreen
import com.example.newsroom.util.graph.Graph
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

val colorBtn = Color(0x0BDA51)

val poppinsFontbold = FontFamily(Font(R.font.poppinbold),Font(R.font.poppinssemibold))
val poppinssemiumbold = FontFamily(Font(R.font.poppinssemibold))

@Composable
fun SplashScreen( navController: NavController

) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            // Ảnh ở giữa
            Image(
                painter = painterResource(id = R.drawable.welcome_image),
                contentDescription = "App Logo",
                modifier = Modifier.size(350.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Welcome Users To The Entertainment App",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = poppinsFontbold,
                    fontSize = 30.sp
                ),
                color = Color(0xFF1F41BB)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "The application entertains users every day and has many categories to help users relax and discover new things.",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Gray
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)

            )
            Spacer(modifier = Modifier.height(50.dp))
            Row {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.splash1),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.Center)
                    )

                    Image(
                        painter = painterResource(R.drawable.news),
                        contentDescription = "Overlay Image",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(40.dp)
                            .padding(bottom = 5.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.splash2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.Center)
                    )

                    Image(
                        painter = painterResource(R.drawable.video),
                        contentDescription = "Overlay Image",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(40.dp)
                            .padding(bottom = 5.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.splash3),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.Center)
                    )

                    Image(
                        painter = painterResource(R.drawable.tick),
                        contentDescription = "Overlay Image",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(50.dp)
                            .padding(bottom = 5.dp)
                    )
                }
            }
        }
    }


    LaunchedEffect(Unit) {
        delay(3000)
        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()){
            navController.navigate(AuthScreen.SignUp.route) {
                popUpTo(AuthScreen.SPLASH.route) { inclusive = true }
            }
        }else {
            navController.navigate(Graph.MAIN_SCREEN_PAGE) {
                popUpTo(AuthScreen.Login.route) { inclusive = true }
            }
        }
    }

}