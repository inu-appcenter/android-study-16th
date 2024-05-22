package dev.kichan.week5.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kichan.week5.model.Comment
import dev.kichan.week5.ui.theme.Week5Theme
import java.time.format.DateTimeFormatter

@Composable
fun CommentItem(comment: Comment, onRemove : (Comment) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1.0f)
        ) {
            Text(
                text = comment.comment, style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = comment.date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")))
        }

        IconButton(onClick = { onRemove(comment) }) {
            Icon(imageVector = Icons.Default.Close, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommentItemPrev() {
    val comment = Comment(1, "안녕하세요", "2024-05-19T12:34:56.0000")
    Week5Theme {
        CommentItem(comment, {})
    }
}