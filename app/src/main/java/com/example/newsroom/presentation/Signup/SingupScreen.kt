package com.example.newsroom.presentation.Signup

import android.content.Context
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newsroom.R
import com.example.newsroom.presentation.Login.LoginViewModel
import com.example.newsroom.util.graph.AuthScreen
import com.example.newsroom.util.graph.Graph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingupScreen(navController: NavController,viewModel: LoginViewModel) {
    val poppinsFontbold = FontFamily(Font(R.font.poppinbold),Font(R.font.poppinssemibold))
    val poppinssemiumbold = FontFamily(Font(R.font.poppinssemibold))

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Image(painter = painterResource(id = R.drawable.image_login), contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Create Account",
                style = TextStyle(
                    fontFamily = poppinsFontbold,
                    fontSize = 30.sp
                ),
                color = Color(0xFF1F41BB)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Please Create Account Then Use App",
                style = TextStyle(
                    fontFamily = poppinssemiumbold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center,
                color = Color(0xFF000000)
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor  = Color(0xFFF1F4FF), // Thiết lập màu nền
                    focusedIndicatorColor = Color.Transparent, // Ẩn gạch châm khi được focus
                    unfocusedIndicatorColor = Color.Transparent // Ẩn gạch châm khi không được focus
                ),
                singleLine = false,
                label = { Text(text = "Email") },
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor  = Color(0xFFF1F4FF), // Thiết lập màu nền
                    focusedIndicatorColor = Color.Transparent, // Ẩn gạch châm khi được focus
                    unfocusedIndicatorColor = Color.Transparent // Ẩn gạch châm khi không được focus
                ),
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                text = "Forgot Password?",
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontFamily = poppinssemiumbold,
                    fontSize = 14.sp
                ),
                color = Color(0xFF1F41BB)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {
                Button(
                    onClick = {  viewModel.CreateWithEmailAndPassword(email,password){
                        navController.navigate(Graph.MAIN_SCREEN_PAGE) {
                            popUpTo(AuthScreen.SignUp.route) { inclusive = true }
                        } }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1F41BB),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "Signup",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            TextButton(onClick = { navController.navigate(AuthScreen.Login.route) }) {
                Text(
                    text = "Login Account",
                    style = TextStyle(
                        fontFamily = poppinssemiumbold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.width(250.dp),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF000000)
                )
            }
        }
    }

}
