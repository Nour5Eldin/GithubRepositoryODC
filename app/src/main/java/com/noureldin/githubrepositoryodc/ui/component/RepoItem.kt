package com.noureldin.githubrepositoryodc.ui.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.noureldin.githubrepositoryodc.R

@Composable
fun RepoItem() {
    val imageCrossFadeAnimationDuration = 1000
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clickable {
                // وضع الحدث هنا
            },
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "http//...").apply {
                            crossfade(imageCrossFadeAnimationDuration)
                            placeholder(R.drawable.ic_github)
                            error(R.drawable.ic_github)
                        }.build()
                ),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp)
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Column(
                Modifier.padding(12.dp)
            ) {
                Row {
                    Text(text = "Title", modifier = Modifier.weight(1f))
                    Text(text = "Title")
                    Icon(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }

                Text("RepoOwner", color = MaterialTheme.colorScheme.onSurface)
                Text(
                    "Description GitHub is a Microsoft company that provides software development hosting and version control using Git.",
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 12.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}


@Preview
@Composable
private fun PreviewRepoItem() {
    RepoItem()
}