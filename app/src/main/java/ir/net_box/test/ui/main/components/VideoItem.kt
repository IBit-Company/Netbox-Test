package ir.net_box.test.ui.main.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Border
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.StandardCardContainer
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import ir.net_box.test.R
import ir.net_box.test.domain.model.Video

@Composable
fun VideoItem(
    video: Video,
    onClick: (Video) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFocused by rememberSaveable { mutableStateOf(false) }

    StandardCardContainer(
        imageCard = {
            VideoCover(
                video = video,
                interactionSource = it,
                onClick = onClick,
            )
        },
        title = {
            Spacer(modifier = Modifier.size(8.dp))

            VideoTitle(
                video = video,
                isFocused = isFocused,
            )
        },
        modifier = modifier
            .wrapContentWidth()
            .onFocusChanged { focusState: FocusState ->
                isFocused = focusState.isFocused
            },
    )
}

@Composable
fun VideoTitle(
    video: Video,
    isFocused: Boolean,
    modifier: Modifier = Modifier,
) {
    val scale by animateFloatAsState(
        targetValue = if (isFocused) 1.1f else 1f,
        label = "Title Scale",
    )

    val color by animateColorAsState(
        targetValue = if (isFocused) Color.White else Color.LightGray,
        label = "Title Color",
    )

    Text(
        color = color,
        text = video.name,
        style = MaterialTheme.typography.titleSmall,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
        modifier = modifier
            .width(120.dp)
            .height(with(LocalDensity.current) { 50.sp.toDp() }) // 50 sp is two lineHeight in title medium
            .scale(scale = scale),
    )
}

@Composable
fun VideoCover(
    video: Video,
    interactionSource: MutableInteractionSource,
    onClick: (Video) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = { onClick(video) },
        border = CardDefaults.border(
            focusedBorder = Border(
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.White,
                ),
                shape = MaterialTheme.shapes.medium,
            ),
        ),
        scale = CardDefaults.scale(focusedScale = 1.05f),
        interactionSource = interactionSource,
        shape = CardDefaults.shape(shape = MaterialTheme.shapes.medium),
        modifier = modifier
            .height(120.dp)
            .aspectRatio(16 / 9f),
    ) {
        AsyncImage(
            model = video.thumbnail,
            placeholder = painterResource(R.drawable.placeholder),
            contentDescription = video.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Preview
@Composable
private fun SuggestedMovieItemPreview() {
    VideoItem(video = Video.fake(), onClick = {})
}
