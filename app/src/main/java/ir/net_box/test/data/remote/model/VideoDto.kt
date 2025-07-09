package ir.net_box.test.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoDto(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String?,
    val file_src: String?,
    val duration: Int
)