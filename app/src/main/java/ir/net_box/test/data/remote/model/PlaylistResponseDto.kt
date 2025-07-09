package ir.net_box.test.data.remote.model

data class PlaylistResponseDto(
    val id: Int,
    val name: String,
    val videos: List<VideoDto>
)