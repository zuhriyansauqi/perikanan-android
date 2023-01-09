package com.zuhriyansauqi.efishery.core_ui.screen

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface FeatureScreen {
  fun registerGraph(
    navGraphBuilder: NavGraphBuilder,
    navController: NavHostController,
    modifier: Modifier = Modifier
  )
}
