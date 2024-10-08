package com.noureldin.githubrepositoryodc.ui.component


import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noureldin.githubrepositoryodc.R

@ExperimentalMaterial3Api
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    showBackButton: Boolean = true,
    titleStyle : TextStyle= MaterialTheme.typography.titleLarge,
    onBackButtonClicked: () -> Unit = {}

    ) {
    CenterAlignedTopAppBar(
        title= {
            Text( text = stringResource(title),
                style = titleStyle,
            )
        },

        modifier= modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(bottom = 6.dp),
        navigationIcon = {
            if (showBackButton){
                IconButton(onClick = {onBackButtonClicked() }
                ) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )

                }
            }
        }
    )

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewAppBar() {
    AppBar(
        title = R.string.app_name,
        showBackButton = false
    )
}