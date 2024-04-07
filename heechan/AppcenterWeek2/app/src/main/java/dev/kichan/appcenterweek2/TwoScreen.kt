package dev.kichan.appcenterweek2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.kichan.appcenterweek2.ui.component.AppBar
import dev.kichan.appcenterweek2.ui.theme.AppcenterWeek2Theme

@Composable
fun TwoScreen(navController: NavHostController) {
    val count = rememberSaveable { mutableStateOf(1) }
    Scaffold(
        topBar = { AppBar({ navController.popBackStack() }, "Two") }
    ) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "가".repeat(count.value), style = TextStyle(fontSize = 32.sp),
                modifier = Modifier.padding(40.dp, 20.dp)
            )

            Row(
                modifier = Modifier.padding(20.dp, 16.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    onClick = { count.value -= 1 },
                    Modifier.weight(1f),
                    enabled = count.value > 1
                ) {
                    Text(text = "삭제", style = TextStyle(fontSize = 20.sp))
                }

                Button(
                    onClick = { count.value += 1 },
                    Modifier.weight(1f)
                ) {
                    Text(text = "추가", style = TextStyle(fontSize = 20.sp))
                }
            }
        }
    }
}

@Preview
@Composable
fun TwoScreenPreview() {
    AppcenterWeek2Theme {
        TwoScreen(rememberNavController())
    }
}