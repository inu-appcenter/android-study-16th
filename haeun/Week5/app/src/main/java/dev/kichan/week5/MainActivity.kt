package dev.kichan.week5

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.kichan.week5.component.CommentItem
import dev.kichan.week5.model.Comment
import dev.kichan.week5.model.CommentDatabase
import dev.kichan.week5.ui.theme.Week5Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyaApp(this)
                }
            }
        }
    }
}

@Composable
fun MyaApp(context: Context) {
    val db: CommentDatabase by lazy {
        CommentDatabase.getInstance(context)
    }

    val state = rememberSaveable { mutableStateOf(State.OK) }
    val inputComment = rememberSaveable { mutableStateOf("") }
    val commentList = rememberSaveable { mutableStateOf(listOf<Comment>()) }

    fun getComment() {
        state.value = State.LOADING

        CoroutineScope(Dispatchers.IO).launch {
            val result = db.commentDao().getAll()
            withContext(Dispatchers.Main) {
                commentList.value = result
                state.value = State.OK
            }
        }
    }

    fun addComment(commentValue: String) {
        val comment = Comment(
            comment = commentValue,
        )

        state.value = State.LOADING

        CoroutineScope(Dispatchers.IO).launch {
            db.commentDao().addComment(comment)

            withContext(Dispatchers.Main) {
                inputComment.value = ""
                state.value = State.OK

                getComment()
            }
        }
    }

    fun removeComment(comment: Comment) {
        state.value = State.LOADING

        CoroutineScope(Dispatchers.IO).launch {
            db.commentDao().removeComment(comment)
            withContext(Dispatchers.Main) {
                state.value = State.OK

                getComment()
            }
        }
    }

    getComment()

    Scaffold {
        Column(Modifier.padding(it)) {
            if(state.value == State.LOADING) {
                Text(text = "로딩중")
            }
            LazyColumn(modifier = Modifier.weight(1.0f)) {
                items(commentList.value) {
                    CommentItem(comment = it, { removeComment(it) })
                }
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { getComment() }
            ) {
                Text(text = "가져오기")
            }

            Row {
                TextField(
                    modifier = Modifier.weight(1.0f),
                    value = inputComment.value,
                    onValueChange = { inputComment.value = it },
                    placeholder = { Text(text = "댓글") }
                )

                Button(onClick = { addComment(inputComment.value) }) {
                    Text(text = "추가")
                }
            }
        }
    }
}

//@Preview
@Composable
fun MyAppPreview() {
    Week5Theme {
        MyaApp(context = LocalContext.current)
    }
}