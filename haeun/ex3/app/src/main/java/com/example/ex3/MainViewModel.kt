package com.example.ex3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private val _counter = MutableLiveData<Int>()
    val counter : LiveData<Int>
        get() = _counter
    init {
        _counter.value = 0
    }

    fun plusCount() {
        _counter.value = counter.value?.plus(1)
    }

    fun minusCount() {
        _counter.value = counter.value?.minus(1)
    }
}