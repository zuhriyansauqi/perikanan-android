package com.zuhriyansauqi.efishery.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.items
import com.zuhriyansauqi.efishery.core_ui.ui.theme.EfisheryTheme
import com.zuhriyansauqi.efishery.ui.main.components.FisheryCard
import compose.icons.FeatherIcons
import compose.icons.feathericons.Plus
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MainScreen(
  navController: NavController = rememberNavController(),
  viewModel: MainVM = koinViewModel()
) {
  val fisheries = viewModel.fisheries()

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(text = stringResource(id = R.string.toolbar_title))
        },
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        )
      )
    },
    floatingActionButton = {
      FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = FeatherIcons.Plus, contentDescription = null)
      }
    },
  ) {
    Box(
      modifier = Modifier
        .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding())
    ) {
      LazyColumn(
        contentPadding = PaddingValues(all = 16.dp),
        modifier = Modifier
          .fillMaxSize()
      ) {
        items(fisheries) { item ->
          item?.let { fishery ->
            fishery.uuid?.run {
              FisheryCard(
                item = fishery,
                onDeleteClick = { currentFishery ->
                  currentFishery.uuid?.run {
                    viewModel.delete(this)
                    fisheries.refresh()
                  }
                }
              )
            }
          }
        }
      }
    }
  }
}

@Preview("Main Screen")
@ExperimentalMaterial3Api
@Composable
fun Preview_MainScreen() {
  EfisheryTheme {
    MainScreen()
  }
}
