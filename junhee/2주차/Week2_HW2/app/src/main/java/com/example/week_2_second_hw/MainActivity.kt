@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.week_2_second_hw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week_2_second_hw.ui.theme.Week_2_second_HWTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week_2_second_HWTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = AnotherScreen.Maincontent.name,

                    ){
                        composable(route = AnotherScreen.Maincontent.name){
                            Maincontent(navController = navController)
                        }
                        composable(route = AnotherScreen.Part_One.name){
                            Part_One(navController = navController)
                        }
                        composable(route = AnotherScreen.Part_Two.name){
                            Part_Two(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

enum class AnotherScreen(){
    Maincontent(),
    Part_One(),
    Part_Two()
}

@Composable
fun Maincontent(modifier: Modifier = Modifier, navController: NavController) {

    Surface(modifier = modifier) {
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {navController.navigate(AnotherScreen.Part_One.name) },
                    contentPadding = PaddingValues(4.dp)
                ) {
                    Text(text = "Screen One 이동")
                }

                Button(
                    onClick = { navController.navigate(AnotherScreen.Part_Two.name) },
                    contentPadding = PaddingValues(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Cyan,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Screen Two 이동")
                }
            }


            LazyColumn {
                items(14) {
                    ItemCard(order = it)
                }
            }
        }
    }
}
@Composable
fun ItemCard(order: Int){
    Card(
        Modifier
            .padding(2.dp)
            .border(width = 1.dp, color = Color.Black)
            .fillMaxWidth()
            .height(40.dp)
    ){
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
            ){
            Text("Item : $order")
        }
    }
}



@Composable
fun Part_One(modifier: Modifier = Modifier, navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Screen One", fontSize = 16.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "go_back"
                        )

                    }
                },
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            val change_text = remember {
                mutableStateOf("Screen One")
            }
            Text(text = change_text.value, fontSize = 24.sp)
            Button(onClick = { change_text.value = "Screen Three" }) {
                Text(text = "Change the text")
            }
        }
    }
}

@Composable
fun Part_Two(modifier: Modifier = Modifier, navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Screen Two", fontSize = 16.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "go_back"
                        )

                    }
                },
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            val count = remember {
                mutableStateOf(0)
            }
            Text(text = count.value.toString(), fontSize = 24.sp)
            Button(onClick = { count.value += 1}) {
                Text(text = "Count Up")
            }
        }
    }
}


@Preview(showBackground = true, heightDp = 800, widthDp = 300)
@Composable
fun MaincontentPreview() {
    Week_2_second_HWTheme {
        Part_Two(navController = rememberNavController())
    }
}