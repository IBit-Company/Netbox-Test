package ir.net_box.test.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.net_box.test.data.remote.VideoPagingSource
import ir.net_box.test.data.remote.api.NetBoxApi
import ir.net_box.test.domain.model.Video
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPagedVideosUseCase @Inject constructor(
    private val api: NetBoxApi
) {
    operator fun invoke(playlistId: Int): Flow<PagingData<Video>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { VideoPagingSource(api, playlistId) }
        ).flow
    }
}
