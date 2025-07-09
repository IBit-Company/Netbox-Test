package ir.net_box.test.domain.usecase

import ir.net_box.test.domain.model.PlayList
import ir.net_box.test.domain.repository.VideoRepository
import javax.inject.Inject

class GetPlaylistUseCase @Inject constructor(
    private val repository: VideoRepository
) {
    suspend operator fun invoke(playlistId: Int, page: Int): PlayList {
        return repository.getPlaylist(playlistId, page)
    }
}