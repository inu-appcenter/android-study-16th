package com.example.ex_ui_compose

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
import com.example.ex_ui_compose.ui.theme.Ex_ui_composeTheme
//메인 화면을 구성하는 composable 함수
@Composable
fun MainScreen(
    navController: NavHostController
){
    // 전체 화면을 채우는 column 사용
    Column(
        Modifier.fillMaxSize() // 사용할 수 있는 최대 공간 가능한 많은 공간을 차지
    ) {
        // 화면 상단에 버튼을 가로 정렬하는 Row 사용
        Row(
            Modifier.fillMaxWidth(), // 부모 요소의 가로 공간을 모두 채우기
            horizontalArrangement = Arrangement.SpaceEvenly // 자식 요소(버튼 두개) 수평 정렬할 때 간격 조정, 요소들 간격 균등
        ) {
            // Screen One으로 이동하는 버튼
            Button(onClick = { navController.navigate(Screen.One.name) }) {// navController를 통해 screen one으로 이동, string으로 써야함
                Text(text = "Screen One 이동")
            }
            // Screen Two로 이동하는 버튼
            Button(onClick = { navController.navigate(Screen.Two.name) }) {
                Text(text = "Screen Two 이동")
            }
        }
        // 여러 아이템을 나열하는 LazyColumn 사용
        LazyColumn{// 화면에 표시 가능한 아이템의 수에 제한이 없는 세로 스크롤 가능한 컬럼
            // 50개의 아이템을 생성하여 표시
            items(50){
                Text(
                    text = "Item ${it + 1}",
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
// 메인 화면의 미리보기
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    // 테마를 적용하여 메인 화면을 미리보기
    Ex_ui_composeTheme {
        MainScreen(rememberNavController())
    }
}