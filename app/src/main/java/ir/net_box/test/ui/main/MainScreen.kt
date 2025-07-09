package ir.net_box.test.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.Surface
import ir.net_box.test.domain.model.Video
import ir.net_box.test.ui.components.ErrorView
import ir.net_box.test.ui.components.LoadingView
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
                LoadingView()
            }

            is MainUiState.Error -> {
                ErrorView(
                    errorText = state.message,
                    onRetryClick = { viewModel.loadVideos() }
                )
            }

            is MainUiState.Success -> {
                VideoRow(title = state.title, videos = state.videos, onItemClick = onVideoClick)
            }
        }
    }
}
