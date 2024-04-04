package com.example.counter_compose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _counter = MutableStateFlow<Int>(0)
    val counter = _counter.asStateFlow()

    fun increaseCounter(){
        _counter.update {
            counter.value + 1
        }
    }

    fun decreaseCounter(){
        _counter.update {
            counter.value - 1
        }
    }
}