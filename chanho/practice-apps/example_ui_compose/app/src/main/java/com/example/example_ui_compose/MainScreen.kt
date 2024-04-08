package com.example.example_ui_compose

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
    appNavigationActions: AppNavigationActions,
){

    val items = listOf<Int>(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14,15,16,17,18,19,20
    )


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Button(
                onClick = { appNavigationActions.navigateToOneScreen() },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 30.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "Screen One 이동")
            }
            Button(
                onClick = { appNavigationActions.navigateToTwoScreen() },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 30.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "Screen Two 이동")
            }
        }

        Divider(
            thickness = 2.dp,
            color = Color.LightGray,
            modifier = Modifier
                .padding(vertical = 30.dp)
        )

        LazyColumn{
            items(items){item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .border(width = 2.dp, color = Color.Black, shape = RectangleShape),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "item : $item",
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}