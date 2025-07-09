package ir.net_box.test.domain.repository

import ir.net_box.test.domain.model.PlayList
import ir.net_box.test.domain.model.Video

interface VideoRepository {
    suspend fun getPlaylist(playlistId: Int, page: Int): PlayList
    suspend fun getVideoDetail(id: Int): Video
}