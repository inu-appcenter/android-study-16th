package com.example.example_ui_compose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OneViewModel: ViewModel() {

    private val _text: MutableStateFlow<String> = MutableStateFlow("Screen One")
    val text = _text.asStateFlow()

    fun changeText(){
        _text.update {
            when(text.value){
                "Screen One" -> {
                    "스크린 원"
                }
                "스크린 원" -> {
                    "Screen One"
                }
                else -> {
                    "Screen One"
                }
            }
        }
    }
}