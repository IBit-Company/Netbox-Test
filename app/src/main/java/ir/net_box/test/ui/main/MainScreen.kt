package ir.net_box.test.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import ir.net_box.test.domain.model.Video
import ir.net_box.test.ui.main.components.VideoRow

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onVideoClick: (Video) -> Unit
) {
    val state = viewModel.uiState

    Surface(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is MainUiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color.White)
                }
            }

            is MainUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "خطا: ${state.message}",
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Button(onClick = { viewModel.loadVideos() }) {
                            Text("تلاش مجدد")
                        }
                    }
                }
            }

            is MainUiState.Success -> {
                VideoRow(title = state.title, videos = state.videos, onItemClick = onVideoClick)
            }
        }
    }
}
