package com.example.room_db_compose

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun RoomScreen(
    userViewModel: UserViewModel,
    userDatabase: UserDatabase
){
    val allUsers by userViewModel.allUsers.collectAsState()

// 싱글톤 패턴을 사용한 경우

    val newUser = UserEntity(
        name = "An",
        age = "23",
        gender = "male",
        phoneNumber = "010-4138-6352"
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow{
            items(allUsers){user ->
                Column {
                    Text(text = user.name)
                    Text(text = user.age)
                    Text(text = user.phoneNumber)
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }

        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                userViewModel.insertAllUsers(userDatabase = userDatabase, users = newUser)
            }
        }) {
            Text(text = "add User")
        }
    }
}