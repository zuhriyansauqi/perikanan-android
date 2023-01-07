package com.zuhriyansauqi.efishery.core_ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
internal fun SetupStatusBarColor() {
  val systemUiController = rememberSystemUiController()
  val useDarkIcons = !isSystemInDarkTheme()
  val color = MaterialTheme.colorScheme.surface

  DisposableEffect(systemUiController, useDarkIcons) {
    systemUiController.setSystemBarsColor(
      color = color,
      darkIcons = useDarkIcons,
    )

    onDispose { }
  }
}
