package ir.net_box.test.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.net_box.test.data.remote.api.NetBoxApi
import ir.net_box.test.domain.model.Video
import ir.net_box.test.utils.toDomain

class VideoPagingSource(
    private val api: NetBoxApi,
    private val playlistId: Int
) : PagingSource<Int, Video>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        val page = params.key ?: 1
        return try {
            val resp = api.getPlaylist(playlistId, page, params.loadSize)
            val list = resp.videos.map { it.toDomain() }
            val next = if (list.isEmpty()) null else page + 1
            LoadResult.Page(
                data = list,
                prevKey = if (page == 1) null else page - 1,
                nextKey = next
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Video>) =
        state.anchorPosition?.let { pos ->
            state.closestPageToPosition(pos)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(pos)?.nextKey?.minus(1)
        }
}
