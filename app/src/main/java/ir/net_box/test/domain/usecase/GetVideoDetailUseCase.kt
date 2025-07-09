package ir.net_box.test.domain.usecase

import ir.net_box.test.domain.model.Video
import ir.net_box.test.domain.repository.VideoRepository
import javax.inject.Inject

class GetVideoDetailUseCase @Inject constructor(
    private val repository: VideoRepository
) {
    suspend operator fun invoke(id: Int): Video {
        return repository.getVideoDetail(id)
    }
}
