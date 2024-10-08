package com.noureldin.githubrepositoryodc.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noureldin.githubrepositoryodc.ui.component.AppBar
import com.noureldin.githubrepositoryodc.R
import com.noureldin.githubrepositoryodc.ui.component.AnimatedShimmer
import com.noureldin.githubrepositoryodc.ui.component.RepoItem
import com.noureldin.githubrepositoryodc.ui.theme.GithubRepositoryODCTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoListScreen(
    modifier: Modifier = Modifier

) {
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(3000)
        isLoading = false
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            AppBar(
                title = R.string.app_name,
                showBackButton = false
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
    ){ innerPadding ->
        LazyColumn (
            Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        ){
            if (isLoading){
                items(5){
                    AnimatedShimmer()
                }
            }else{
                items(listOf("","","","","")){
                    RepoItem()

                }
            }



        }

    }
}

@Preview
@Composable
private fun PreviewRepoListScreen() {
    GithubRepositoryODCTheme{
        RepoListScreen()
    }

}