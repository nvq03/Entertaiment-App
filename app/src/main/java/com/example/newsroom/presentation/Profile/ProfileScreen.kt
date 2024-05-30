package com.example.newsroom.presentation.Profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newsroom.R
import com.example.newsroom.presentation.Login.LoginViewModel

@Composable
fun ProfileScreen(navController: NavController, viewModel: LoginViewModel) {
    val poppinsFontbold = FontFamily(Font(R.font.poppinbold), Font(R.font.poppinssemibold))
    val poppinssemiumbold = FontFamily(Font(R.font.poppinssemibold))
    val userInfo by viewModel.userInfo.observeAsState()
    val mContext = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getUserInfo()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .background(Color(0xFF166FFF), RoundedCornerShape(bottomStart = 100.dp))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "Your Image",
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    userInfo?.let {
                    Text(
                        text = "${it.Name}",
                        style = TextStyle(
                            fontFamily = poppinssemiumbold,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(top = 15.dp),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = "${it.Email}",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color(0xFF9FBFF4)
                        ),
                        modifier = Modifier

                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = "${it.userVersion}",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color(0xFF9FBFF4)
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(20.dp)

                    )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.White)
                    .border(width = 2.dp, color = Color.Gray)
                    .clip(RoundedCornerShape(topEnd = 30.dp))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFD3E3FD)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clickable {
                            }
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.setting),
                                contentDescription = "Settings",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(25.dp))
                            Column {
                                Text(
                                    text = "Settings",
                                    style = TextStyle(
                                        fontFamily = poppinssemiumbold,
                                        fontSize = 18.sp
                                    ),
                                    modifier = Modifier.padding(top = 5.dp).clickable { mToast(mContext,"Setting App Comming Soon") },
                                    color = Color(0xFF166FFF)
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(
                                    text = "Settings and features are here",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color(0xFF89B6FF)
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFD3E3FD)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clickable {

                            }
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.contact),
                                contentDescription = "Contact Us",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(25.dp))
                            Column {
                                Text(
                                    text = "Contact Us",
                                    style = TextStyle(
                                        fontFamily = poppinssemiumbold,
                                        fontSize = 18.sp
                                    ),
                                    modifier = Modifier.padding(top = 5.dp).clickable { mToast(mContext,"Contact Us QuyAndroid@gmail.com") },
                                    color = Color(0xFF166FFF)
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(
                                    text = "Complain or ask for help",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color(0xFF89B6FF)
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Card 3
                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFD3E3FD)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clickable {

                            }
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.about),
                                contentDescription = "About",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(25.dp))
                            Column {
                                Text(
                                    text = "About",
                                    style = TextStyle(
                                        fontFamily = poppinssemiumbold,
                                        fontSize = 18.sp
                                    ),
                                    modifier = Modifier.padding(top = 5.dp).clickable { mToast(mContext,"The Entertaiment App") },
                                    color = Color(0xFF166FFF)
                                )
                                Spacer(modifier = Modifier.height(1.dp))
                                Text(
                                    text = "Know more details about us",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color(0xFF89B6FF)
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun mToast(context: Context, text: String){
    Toast.makeText(context, "$text", Toast.LENGTH_LONG).show()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun test() {

}