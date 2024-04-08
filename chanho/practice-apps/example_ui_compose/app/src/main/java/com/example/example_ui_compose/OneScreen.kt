package com.example.example_ui_compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneScreen(
    appNavigationActions: AppNavigationActions,
    oneViewModel: OneViewModel
){
    val text by oneViewModel.text.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = text)
            },
            navigationIcon = {
                IconButton(onClick = { appNavigationActions.navigateToMainScreen() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                navigationIconContentColor = Color.Black,
                containerColor = Color.White,
                titleContentColor = Color.Black
            )
        )

        
        Text(
            text = text,
            style = TextStyle(
                fontSize = 30.sp
            )
        )

        Button(
            onClick = {
                oneViewModel.changeText()
            }
        ) {
            Text(text = "Change the Text")
        }



    }

}