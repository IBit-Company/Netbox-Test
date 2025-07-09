package ir.net_box.test.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Text

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    errorText: String,
    onRetryClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "خطا: $errorText",
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(onClick = onRetryClick) {
                Text("تلاش مجدد")
            }
        }
    }
}

@Preview
@Composable
private fun ErrorViewPreview() {
    ErrorView(
        errorText = "Sample error Text!!",
        onRetryClick = {}
    )
}