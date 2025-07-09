package ir.net_box.test.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaylistResponseDto(
    val id: Int,
    val name: String,
    val videos: List<VideoDto>
)