package ir.net_box.test.data.repository

import ir.net_box.test.data.remote.api.NetBoxApi
import ir.net_box.test.domain.model.Video
import ir.net_box.test.domain.repository.VideoRepository
import ir.net_box.test.utils.toDomain
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val api: NetBoxApi
) : VideoRepository {

    override suspend fun getPlaylist(playlistId: Int, page: Int): List<Video> {
        return api.getPlaylist(playlistId, page).videos.map { it.toDomain() }
    }

    override suspend fun getVideoDetail(id: Int): Video {
        return api.getVideoDetail(id).toDomain()
    }
}