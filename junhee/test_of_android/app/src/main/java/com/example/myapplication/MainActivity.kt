package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    fun onBtnClicked(view: View) {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "1주차 미션 완료..?"
    }
    fun onBtn2Clicked(view: View) {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "나 인간 승리 해버린 ㅋㅋ"
    }
}