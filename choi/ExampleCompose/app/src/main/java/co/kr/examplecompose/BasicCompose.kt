package co.kr.examplecompose


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import co.kr.examplecompose.ui.theme.ExampleComposeTheme

@Composable
fun BasicCompose(
    navController : NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(AllUI.ScreenOneEx.name) }
            ) {
                Text(text = "Screen One 이동")
            }

            Spacer(modifier = Modifier.width(24.dp))

            FilledTonalButton(
                onClick = { navController.navigate(AllUI.ScreenTwoEx.name) }
            ) {
                Text(text = "Screen Two 이동")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Divider()

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(20) {
                Spacer(modifier = Modifier.height(16.dp))

                ExampleComponent(idx = it + 1)
            }
        }
    }
}

@Preview
@Composable
fun PreBasicCompose() {
    ExampleComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            BasicCompose(
                navController = rememberNavController()
            )
        }
    }
}