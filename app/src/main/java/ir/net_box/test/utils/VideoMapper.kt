package ir.net_box.test.utils

import ir.net_box.test.data.remote.model.VideoDto
import ir.net_box.test.domain.model.Video

fun VideoDto.toDomain(): Video {
    return Video(
        id = id,
        name = name,
        description = description,
        thumbnail = thumbnail,
        fileUrl = file_src,
        duration = duration
    )
}