package com.mkrdeveloper.lazyrowonclickexamplejetpack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newsroom.R
import com.example.newsroom.domain.model.BottomBarScreen
import com.example.newsroom.domain.model.Foods


@Composable
fun MainScreenFood(
    foodItems: List<Foods>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val poppinsFontbold = FontFamily(Font(R.font.poppinbold), Font(R.font.poppinssemibold))
    val poppinssemiumbold = FontFamily(Font(R.font.poppinssemibold))

    Column {
        Text(
            text = "Delicious Food Every Day",
            style = TextStyle(
                fontFamily = poppinsFontbold,
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
            color = Color(0xFF1F41BB)
        )
        Text(
            text = "Food includes preparation methods and recipes",
            style = TextStyle(
                fontFamily = poppinssemiumbold,
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(start = 10.dp),
            color = Color.Black
        )


        LazyColumn(contentPadding = PaddingValues(6.dp, bottom = 75.dp)) {
            items(foodItems) { food ->
                ColumnItem(
                    modifier = modifier,
                    painter = food.imageId,
                    title = food.name,
                    ingredients = food.ingredients,
                    food = food,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier = Modifier,
    painter: Int,
    title: String,
    ingredients: String,
    food: Foods,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/${food.name}/${food.ingredients}/${food.imageId}")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter),
                contentDescription = title,
                modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = ingredients, fontSize = 18.sp, maxLines = 3, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}