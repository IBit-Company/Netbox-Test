package ir.net_box.test.domain.model

data class Video(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String?,
    val fileUrl: String?,
    val duration: Int
)