package dev.kichan.week4

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kichan.week4.ui.theme.Week4Theme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PigListItem(pigItem: PigItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffdee2e6), RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Text(
            text = pigItem.nes_cn.trim(),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = pigItem.date.format(DateTimeFormatter.ofPattern("yyyy년 MM일 DD일"))
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PigListItemPreview() {
    Week4Theme {
        PigListItem(pigItem = PigItem("", "밥먹기", "20221231"))
    }
}