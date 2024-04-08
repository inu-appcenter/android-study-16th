package com.example.ex_ui_compose
import androidx.compose.foundation.border
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ex_ui_compose.ui.theme.Ex_ui_composeTheme
import com.example.ex_ui_compose.ui.theme.AppBar

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
                text = "안드로이드 출석부".repeat(count.value), style = TextStyle(fontSize = 32.sp),
                modifier = Modifier.padding(40.dp, 20.dp)
            )

            LazyColumn{// 화면에 표시 가능한 아이템의 수에 제한이 없는 세로 스크롤 가능한 컬럼
                // 리스트에 이름 저장
                val names = listOf("최명윤", "김하은","박희찬", "안찬호", "이준희")
                items(names.size){ index ->
                    val name = names[index] // 첫번째부터 가져오기
                    Text(
                        text = "이름 : $name",
                        Modifier
                            .fillMaxWidth() //최대 가로 너비
                            .padding(bottom = 12.dp)
                            .border(1.dp, Color.Black) // 1dp 두께의 검은색 테두리 추가
                            .padding(8.dp)
                        ,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TwoScreenPreview() {
    Ex_ui_composeTheme {
        TwoScreen(rememberNavController())
    }
}