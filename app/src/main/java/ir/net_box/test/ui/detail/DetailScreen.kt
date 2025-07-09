package ir.net_box.test.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import ir.net_box.test.domain.model.Video
import ir.net_box.test.ui.components.ErrorView
import ir.net_box.test.ui.components.LoadingView

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    videoId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    LaunchedEffect(Unit) {
        viewModel.loadVideo(videoId)
    }

    val state = viewModel.uiState

    Surface(modifier = modifier.fillMaxSize()) {
        when (state) {
            is DetailUiState.Loading -> {
                LoadingView()
            }

            is DetailUiState.Error -> {
                ErrorView(
                    errorText = state.message,
                    onRetryClick = { viewModel.loadVideo(videoId) }
                )
            }

            is DetailUiState.Success -> {
                VideoDetail(video = state.video)
            }
        }
    }
}

@Composable
fun VideoDetail(video: Video, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        AsyncImage(
            model = video.thumbnail,
            contentDescription = video.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = video.name,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = video.description,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }
}

@Preview
@Composable
private fun VideoDetailPreview() {
    VideoDetail(
        video = Video.fake()
    )
}
