package ir.net_box.test.utils

import ir.net_box.test.data.remote.model.PlaylistResponseDto
import ir.net_box.test.domain.model.PlayList

fun PlaylistResponseDto.toDomain(): PlayList {
    return PlayList(
        title = name,
        videos = videos.map { it.toDomain() },
    )
}