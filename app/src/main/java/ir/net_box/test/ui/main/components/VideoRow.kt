package ir.net_box.test.ui.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import ir.net_box.test.domain.model.Video
import ir.net_box.test.utils.ifElse

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun VideoRow(
    title: String,
    videos: List<Video>,
    onItemClick: (Video) -> Unit,
    modifier: Modifier = Modifier
) {
    val firstItemFocusRequester = remember { FocusRequester() }

    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        LazyRow(
            modifier = Modifier.focusRestorer(firstItemFocusRequester),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            itemsIndexed(items = videos) { index, video ->
                VideoItem(
                    video = video,
                    onClick = onItemClick,
                    modifier = Modifier
                        .ifElse(
                            condition = index == 0,
                            ifTrueModifier = Modifier.focusRequester(firstItemFocusRequester),
                        ),
                )
            }
        }

        LaunchedEffect(videos.size) {
            if (videos.isNotEmpty()) {
                firstItemFocusRequester.requestFocus()
            }
        }
    }
}

@Preview
@Composable
private fun VideoRowPreView() {
    VideoRow(
        title = "Video Row",
        videos = Video.fakeList(),
        onItemClick = {},
    )
}