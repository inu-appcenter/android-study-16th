package com.example.ex_ui_compose

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ex_ui_compose.ui.theme.Ex_ui_composeTheme
import androidx.compose.material3.Scaffold
import com.example.ex_ui_compose.component.AppBar

@RequiresApi(Build.VERSION_CODES.O)

@Composable
fun OneScreen(
    navController: NavHostController
){
    // 텍스트 인덱스, 텍스트 리스트 선언
    val textIndex = rememberSaveable { mutableIntStateOf(0) }
    // remembersaveable: 구성 변경 사항으로부터 상태 보존 -> 손실 x -> 변경 가능한 정수 상태 보존
    val textList = listOf<String>(
        "안",
        "녕",
        "하",
        "세",
        "요",
    )

    //scaffold: 머터리얼 디자인을 가진 레이아웃의 기본 구조 제공 가장 높은 수준의 컴포져블
    Scaffold(
        topBar = { AppBar({ navController.popBackStack() }, "One") }
    ) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = textList[textIndex.value], style = TextStyle(
                fontSize = 28.sp
            )
            )
            Button(
                onClick = {
                    textIndex.value += 1 // 변수 증가
                    textIndex.value %= textList.size
                },
                Modifier.padding(top = 32.dp)
            ) {
                Text(text = "Change the Text")
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun OneScreenPreview() {
    Ex_ui_composeTheme {
        OneScreen(rememberNavController())
    }
}