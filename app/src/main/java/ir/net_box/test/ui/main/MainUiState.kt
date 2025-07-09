package ir.net_box.test.ui.main

import ir.net_box.test.domain.model.Video

sealed class MainUiState {
    object Loading : MainUiState()
    data class Success(val videos: List<Video>) : MainUiState()
    data class Error(val message: String) : MainUiState()
}