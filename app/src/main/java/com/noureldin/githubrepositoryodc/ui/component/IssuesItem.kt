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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.noureldin.githubrepositoryodc.R

@Composable
fun IssuesItem(issueDescription: String, issueStatus: String) {
    val imageCrossFadeAnimationDuration = 1000
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clickable {
                // Add click action here
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
                        .data(data = "http://example.com/placeholder.png") // Replace with your image URL
                        .apply {
                            crossfade(imageCrossFadeAnimationDuration)
                            placeholder(R.drawable.ic_issues)
                            error(R.drawable.ic_issues)
                        }.build()
                ),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp)
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Row {
                    Text(text = issueDescription, modifier = Modifier.weight(1f))
                    Text(text = issueStatus)
                }

                Text("NONE", color = MaterialTheme.colorScheme.onSurface) // Adjust if necessary
                Text(
                    "Created At : 6-10-2025, 5:30 PM", // Example date
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 12.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewRepoItem() {
    IssuesItem(issueDescription = "Issues with line 46 function..", issueStatus = "Open")
}
