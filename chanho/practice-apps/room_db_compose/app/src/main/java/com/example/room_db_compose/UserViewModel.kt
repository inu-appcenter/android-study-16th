package com.example.room_db_compose

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _allUsers : MutableStateFlow<List<UserEntity>> = MutableStateFlow(emptyList())
    val allUsers = _allUsers.asStateFlow()


    fun getAllChart(userDatabase: UserDatabase){
        viewModelScope.launch(Dispatchers.IO) {

            _allUsers.update {
                userDatabase.userDao().getAll()
            }
        }
    }

    fun insertAllUsers(userDatabase: UserDatabase, users: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            userDatabase.userDao().insertAll(users)
            _allUsers.update {
                userDatabase.userDao().getAll()
            }
        }
    }

    fun deleteUser(userDatabase: UserDatabase, userEntity: UserEntity){
        viewModelScope.launch {
            userDatabase.userDao().delete(user = userEntity)
        }
    }
}