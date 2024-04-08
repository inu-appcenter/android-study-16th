package com.example.ex_ui_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ex_ui_compose.ui.theme.Ex_ui_composeTheme

class MainActivity : ComponentActivity() { // MainActivity는 ComponentActivity를 상속받음
    override fun onCreate(savedInstanceState: Bundle?) { // onCreate 액티비티가 생성될 때 호출
        super.onCreate(savedInstanceState)
        setContent {
            Ex_ui_composeTheme { // 앱의 테마를 설정한다.
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination =  Screen.Main.name) {
                    composable(Screen.Main.name) {
                        MainScreen(navController = navController)
                    }
                    composable(Screen.One.name) {
                        OneScreen(navController = navController)
                    }
                    composable(Screen.Two.name) {
                        TwoScreen(navController = navController)
                    }
                }
            }
        }
    }
}
// 'NavHost'를 사용하여 화면 간의 네비게이션 처리, navController와 startDestination(앱이 시작될 때 표시되는 첫 번째 화면 지정)을 전달.
// 'NavHost'내에서 'composable' 함수를 사용하여 각 화면을 정의 -> Screen enum의 이름을 사용
