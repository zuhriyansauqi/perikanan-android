package com.zuhriyansauqi.efishery.ui.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@ExperimentalMaterial3Api
class MainFeatureScreenImpl : MainFeatureScreen {
  private val baseRoute = "main"

  override fun homeRoute() = baseRoute

  override fun registerGraph(
    navGraphBuilder: NavGraphBuilder,
    navController: NavHostController,
    modifier: Modifier
  ) {
    navGraphBuilder.composable(baseRoute) {
      MainScreen(navController = navController)
    }
  }

}
