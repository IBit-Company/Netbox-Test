package ir.net_box.test.data.remote.model

data class VideoDto(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String?,
    val file_src: String?,
    val duration: Int
)