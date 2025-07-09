package ir.net_box.test.ui.detail

import ir.net_box.test.domain.model.Video

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val video: Video) : DetailUiState()
    data class Error(val message: String) : DetailUiState()
}