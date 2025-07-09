package ir.net_box.test.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.net_box.test.domain.usecase.GetVideoDetailUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getVideoDetailUseCase: GetVideoDetailUseCase
) : ViewModel() {

    var uiState by mutableStateOf<DetailUiState>(DetailUiState.Loading)
        private set

    fun loadVideo(id: Int) {
        viewModelScope.launch {
            uiState = DetailUiState.Loading
            try {
                val video = getVideoDetailUseCase(id)
                uiState = DetailUiState.Success(video)
            } catch (e: Exception) {
                uiState = DetailUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
