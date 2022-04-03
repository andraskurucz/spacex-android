package com.akurucz.spacex.launch.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.akurucz.spacex.launch.model.Launch
import androidx.paging.compose.items
import com.akurucz.spacex.R

@Composable
fun LaunchListScreen(viewModel: LaunchViewModel, openLaunchDetails: (Launch) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
        }
    ) {
        LaunchList(viewModel, openLaunchDetails)
    }
}

@Composable
fun LaunchList(viewModel: LaunchViewModel, openLaunchDetails: (Launch) -> Unit) {
    val listItems: LazyPagingItems<ListItem> = viewModel.launchesStream.collectAsLazyPagingItems()
    LazyColumn {
        items(items = listItems) { item ->
            when (item) {
                is ListItem.LaunchItem -> LaunchItemRow(
                    listItem = item,
                    onItemClicked = openLaunchDetails
                )
                is ListItem.Separator -> SeparatorRow(listItem = item)
                null -> {}
            }
        }

        listItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.append is LoadState.Error -> {
                    item { ErrorItem(onRetryClicked = { listItems.retry() }) }
                }
            }
        }
    }
}

@Composable
fun SeparatorRow(listItem: ListItem.Separator, modifier: Modifier = Modifier) {
    val year = listItem.year
    Row(
        modifier
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("$year")
    }
}

@Composable
fun LaunchItemRow(
    listItem: ListItem.LaunchItem,
    onItemClicked: (Launch) -> Unit,
    modifier: Modifier = Modifier
) {
    val launch = listItem.launch
    Row(
        modifier
            .clickable { onItemClicked(launch) }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(launch.missionName)
        Text(launch.rocketName)
    }
}

@Composable
private fun FullScreenLoading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
fun ErrorItem(onRetryClicked: () -> Unit, modifier: Modifier = Modifier) {
    Surface {
        Column(
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.retry_description))
            Button(
                onClick = onRetryClicked
            ) {
                Text(text = stringResource(R.string.retry))
            }
        }
    }
}

@Preview
@Composable
fun PreviewSeparatorRow() {
    val separator = remember { ListItem.Separator(1989) }
    SeparatorRow(listItem = separator, modifier = Modifier.fillMaxWidth())
}


@Preview
@Composable
fun PreviewLaunchRow() {
    val launch = remember { ListItem.LaunchItem(generateRandomLaunch()) }
    LaunchItemRow(listItem = launch, onItemClicked = {}, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewErrorItem() {
    ErrorItem(
        onRetryClicked = {},
        modifier = Modifier.fillMaxWidth()
    )
}

fun generateRandomLaunch(): Launch {
    return Launch(
        missionName = "Mission",
        launchYear = 1989,
        rocketName = "My Rocket"
    )
}
