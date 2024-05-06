package com.example.ex_ui_compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// back 뒤로 가기 버튼을 클릭할 때 실행, 화면의 제목 표시, 기본값 = "Main"
@Preview(showBackground = true)
@Composable
fun AppBar(back : () -> Unit = {}, screenName : String = "Main") {
    // Row를 사용하여 뒤로 가기 버튼(image)와 화면 이름(box)를 나란히 배치
    Row(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Image(
            imageVector = Icons.Default.ArrowBack, contentDescription = null,
            // 뒤로 가기 아이콘 사용, 아이콘에 대한 설명은 x
            modifier = Modifier.clickable {
                back() // 클릭하면 back 함수 호출
            }
        )
        Box(
            Modifier.weight(1f), // 남은 공간은 가득 채우도록
            contentAlignment = Alignment.Center // 내용을 중앙으로 정렬
        ) {
            Text(text = "Screen $screenName")
        }
    }
}