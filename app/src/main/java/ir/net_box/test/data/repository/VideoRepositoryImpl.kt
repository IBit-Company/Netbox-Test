package ir.net_box.test.data.repository

import ir.net_box.test.data.remote.api.NetBoxApi
import ir.net_box.test.domain.model.PlayList
import ir.net_box.test.domain.model.Video
import ir.net_box.test.domain.repository.VideoRepository
import ir.net_box.test.utils.toDomain
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val api: NetBoxApi
) : VideoRepository {

    override suspend fun getPlaylist(playlistId: Int, page: Int): PlayList {
        return api.getPlaylist(playlistId, page).toDomain()
    }

    override suspend fun getVideoDetail(id: Int): Video {
        return api.getVideoDetail(id).toDomain()
    }
}