package dev.kichan.appcenterweek2.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.kichan.appcenterweek2.ui.Screen

@Composable
fun MainScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.navigate(Screen.One.name) }) {
                Text(text = "Screen One 이동")
            }
            Button(onClick = { navController.navigate(Screen.Two.name) }) {
                Text(text = "Screen Two 이동")
            }
        }
        LazyColumn {
            items(50) {
                Text(
                    text = "Item ${it + 1}",
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .border(1.dp, Color.Black)
                        .padding(8.dp)
                    ,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AppcenterWeek2Theme {
        MainScreen(rememberNavController())
    }
}