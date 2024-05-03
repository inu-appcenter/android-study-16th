package com.example.myapplication

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                ) {
                    BackText()
                }
            }
        }
    }
}



@Composable
fun BackText(modifier: Modifier = Modifier){
    var state = remember{ mutableStateOf("2주차 과제")}
    Surface(modifier = modifier.fillMaxSize()){
            Column(modifier = Modifier, Arrangement.Center, Alignment.CenterHorizontally){
                Text(state.value, fontSize = 30.sp)
            }
            Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Bottom) {
                Button(
                    onClick = {state.value = "변경" },
                    contentPadding = PaddingValues(60.dp),
                    modifier = Modifier.wrapContentSize()
            ) {
                Text(text = "클릭1", fontSize = 30.sp)
            }
        }
            Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom) {
                Button(
                    onClick = {state.value = "완료"},
                    contentPadding = PaddingValues(60.dp),
                    modifier = Modifier.wrapContentSize()
            ) {
                Text(text = "클릭2", fontSize = 30.sp)
            }
        }

    }
}


@Composable
@Preview(showBackground = true, heightDp = 600, widthDp = 400)
fun BackTextPreview(){
    MyApplicationTheme{
        BackText()
    }
}