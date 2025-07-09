package ir.net_box.test.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.net_box.test.domain.model.Video
import ir.net_box.test.domain.usecase.GetPagedVideosUseCase
import ir.net_box.test.domain.usecase.GetPlaylistUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPlaylistUseCase: GetPlaylistUseCase,
    private val getPagedVideosUseCase: GetPagedVideosUseCase //TODO I think we can improve that
) : ViewModel() {

    var uiState by mutableStateOf<MainUiState>(MainUiState.Loading)
        private set

    init {
        initVideos()
    }

    fun getPagedVideos(playlistId: Int = 1): Flow<PagingData<Video>> =
        getPagedVideosUseCase(playlistId).cachedIn(viewModelScope)

    fun initVideos(playlistId: Int = 1, page: Int = 1) {
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
