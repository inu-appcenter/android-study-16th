package dev.kichan.appcenterweek2.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun AppBar(back : () -> Unit = {}, screenName : String = "Main") {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Image(
            imageVector = Icons.Default.ArrowBack, contentDescription = null,
            modifier = Modifier.clickable {
                back()
            }
        )
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Screen $screenName")
        }
    }
}