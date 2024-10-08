package com.noureldin.githubrepository.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noureldin.githubrepositoryodc.ui.component.AppBar
import com.noureldin.githubrepositoryodc.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoDetailsScreen() {
    Scaffold(
        topBar = {
            AppBar(
                title = R.string.detail,
                showBackButton = true
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "RepoLogo",
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "language",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StateItem(text = "123400", iconRes = R.drawable.ic_star, tintColor = Color.Yellow)
                        StateItem(text = "Python", iconRes = R.drawable.circle, tintColor = Color.Blue)
                        StateItem(text = "4000", iconRes = R.drawable.ic_fork, tintColor = Color.Black)
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Shared repository for open-sourced projects from the Google AI Language team",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }

                // Button aligned at the bottom of the screen
                Button(
                    onClick = { /* Handle button click */ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)  // Aligns the button to the bottom
                        .padding(16.dp) // Padding around the button
                ) {
                    Text("Show Issues", color = Color.White)
                }
            }
        }
    )
}

@Composable
fun StateItem(text: String, iconRes: Int, tintColor: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = tintColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Preview
@Composable
private fun PreviewRepoDetailsScreen() {
    RepoDetailsScreen()
}
