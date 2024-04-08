package com.example.example_ui_compose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TwoViewModel : ViewModel() {

    private val _counter: MutableStateFlow<Int> = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun plusCounter(){
        _counter.update { counter.value.plus(1) }
    }

    fun minusCounter(){
        _counter.update { counter.value.minus(1) }
    }
}