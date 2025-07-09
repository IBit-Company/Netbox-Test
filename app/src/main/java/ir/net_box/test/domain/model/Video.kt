package ir.net_box.test.domain.model

data class Video(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String?,
    val fileUrl: String?,
    val duration: Int
) {
    companion object {
        fun fake(
            id: Int = 1,
            name: String = "Workout Warm-up",
            description: String = "Start your workout with a proper warm-up routine.",
            thumbnail: String? = "https://example.com/thumbnails/warmup.jpg",
            fileUrl: String? = "https://example.com/videos/warmup.mp4",
            duration: Int = 180
        ): Video {
            return Video(id, name, description, thumbnail, fileUrl, duration)
        }

        fun fakeList(count: Int = 5): List<Video> {
            val names = listOf(
                "Workout Warm-up",
                "HIIT Training",
                "Cool Down",
                "No Thumbnail",
                "Missing File"
            )

            return List(count) { index ->
                val id = index + 1
                val name = names.getOrNull(index) ?: "Sample Video $id"
                val description = "Description for $name"
                val thumbnail =
                    if (name == "No Thumbnail") null else "https://example.com/thumbnails/$id.jpg"
                val fileUrl =
                    if (name == "Missing File") null else "https://example.com/videos/$id.mp4"
                val duration = 120 + (index * 60)

                fake(
                    id = id,
                    name = name,
                    description = description,
                    thumbnail = thumbnail,
                    fileUrl = fileUrl,
                    duration = duration
                )
            }
        }
    }
}