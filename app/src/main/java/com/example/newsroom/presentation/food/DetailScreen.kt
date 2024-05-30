package com.mkrdeveloper.lazyrowonclickexamplejetpack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsroom.domain.model.Foods

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    foodItem: Foods,
    onBackPressed: () -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Top bar with back button
        Box(
            modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = onBackPressed
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }

        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = foodItem.imageId),
                contentDescription = foodItem.name,
                modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(200.dp)
            )
        }

        Column(modifier = Modifier.verticalScroll(rememberScrollState()).padding(bottom = 70.dp)) {
            Text(
                text = foodItem.name,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = foodItem.ingredients,
                fontSize = 18.sp,
            )
        }
    }
}