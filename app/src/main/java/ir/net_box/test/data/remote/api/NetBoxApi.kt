package ir.net_box.test.data.remote.api

import ir.net_box.test.data.remote.model.PlaylistResponseDto
import ir.net_box.test.data.remote.model.VideoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetBoxApi {

    @GET("api/v1/atv/playlist/{playlistId}/")
    suspend fun getPlaylist(
        @Path("playlistId") playlistId: Int,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 10
    ): PlaylistResponseDto

    @GET("api/v1/atv/video/{id}/")
    suspend fun getVideoDetail(
        @Path("id") id: Int
    ): VideoDto

    companion object {
        const val BASE_URL = "https://channels.net-box.ir/"
        const val API_KEY = "43581c49f795564442a066b11e95bcdc7dba9ac6062178d9c2fb65acce4ba761"
    }
}