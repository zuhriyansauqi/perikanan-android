package com.zuhriyansauqi.efishery.core

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zuhriyansauqi.efishery.core_ui.screen.register
import com.zuhriyansauqi.efishery.ui.main.MainFeatureScreen
import getKoinInstance

@ExperimentalMaterial3Api
@Composable
fun AppNavGraph(
  navController: NavHostController
) {
  val mainFeatureScreen = getKoinInstance<MainFeatureScreen>()

  NavHost(
    navController = navController,
    startDestination = mainFeatureScreen.homeRoute()
  ) {
    register(
      featureScreen = mainFeatureScreen,
      navController = navController,
    )
  }
}
