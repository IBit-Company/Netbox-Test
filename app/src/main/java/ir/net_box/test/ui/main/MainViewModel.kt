package ir.net_box.test.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.net_box.test.domain.usecase.GetPlaylistUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPlaylistUseCase: GetPlaylistUseCase
) : ViewModel() {

    var uiState by mutableStateOf<MainUiState>(MainUiState.Loading)
        private set

    init {
        loadVideos()
    }

    fun loadVideos(playlistId: Int = 1, page: Int = 1) {
        viewModelScope.launch {
            uiState = MainUiState.Loading
            try {
                val playList = getPlaylistUseCase(playlistId, page)
                uiState = MainUiState.Success(title = playList.title, videos = playList.videos)
            } catch (e: Exception) {
                uiState = MainUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
