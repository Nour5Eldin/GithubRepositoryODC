package com.noureldin.githubrepositoryodc.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.noureldin.githubrepositoryodc.ui.component.IssuesItem

@Composable
fun RepoIssuesScreen() {
    // Sample issues with descriptions and statuses
    val issues = listOf(
        Pair("Issues with line 46 function..", "Open"),
        Pair("Error in data processing..", "Closed"),
        Pair("NullPointerException in line 27..", "Open"),
        Pair("Infinite loop in line 65..", "Resolved"),
        Pair("Timeout exception in API call..", "Open")
    )

    LazyColumn {
        items(issues) { issue ->
            IssuesItem(issueDescription = issue.first, issueStatus = issue.second)
        }
    }
}

@Preview
@Composable
private fun PreviewRepoIssuesScreen() {
    RepoIssuesScreen()
}
