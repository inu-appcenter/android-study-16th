package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.PracticeTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    // 사용자 목록을 생성
    val userList = remember {
        listOf(
            UserEntity(name = "김하은", age = "22", gender = "Female", phoneNumber = "123-456-7890"),
            UserEntity(name = "최명윤", age = "25", gender = "Male", phoneNumber = "987-654-3210"),
            UserEntity(name = "박희찬", age = "20", gender = "Male", phoneNumber = "135-791-3579"),
            UserEntity(name = "이준희", age = "24", gender = "Male", phoneNumber = "975-319-7531")
        )
    }
    UserList(modifier = Modifier, userList = userList)

}



@Composable
fun UserList(modifier: Modifier ,userList: List<UserEntity>) {
    //lazycolumn으로 리스트 만들기
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(userList) { user ->
            UserItem(user)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun UserItem(user: UserEntity) {
    //사용자 정보 카드 생성
    Card(
        modifier = Modifier.fillMaxWidth(),

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name: ${user.name}")
            Text(text = "Age: ${user.age}")
            Text(text = "Gender: ${user.gender ?: "Unknown"}")
            Text(text = "Phone Number: ${user.phoneNumber}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserItem() {
    UserItem(user = UserEntity(name = "John Doe", age = "30", gender = "Male", phoneNumber = "123-456-7890"))
}

