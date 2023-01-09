package com.zuhriyansauqi.efishery.core_ui.screen

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.register(
  featureScreen: FeatureScreen,
  navController: NavHostController,
  modifier: Modifier = Modifier
) {
  featureScreen.registerGraph(
    navGraphBuilder = this,
    navController = navController,
    modifier = modifier
  )
}
