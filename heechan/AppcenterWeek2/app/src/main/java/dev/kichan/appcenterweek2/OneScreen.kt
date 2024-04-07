package dev.kichan.appcenterweek2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
fun OneScreen(navController: NavHostController) {
    val textIndex = rememberSaveable { mutableStateOf(0) }
    val textList = listOf<String>(
        "대충 텍스트",
        "대충 대충 텍스트",
        "그냥 텍스트",
        "그냥 대충 텍스트",
        "이건 텍스트",
    )

    Scaffold(
        topBar = { AppBar({ navController.popBackStack() }, "One") }
    ) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = textList[textIndex.value], style = TextStyle(fontSize = 28.sp))
            Button(
                onClick = {
                    textIndex.value += 1
                    textIndex.value %= textList.size
                },
                Modifier.padding(top = 32.dp)
            ) {
                Text(text = "Change to Text")
            }
        }
    }
}

@Preview
@Composable
fun OneScreenPreview() {
    AppcenterWeek2Theme {
        OneScreen(navController = rememberNavController())
    }
}