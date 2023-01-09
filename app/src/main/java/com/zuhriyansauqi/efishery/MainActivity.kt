package com.zuhriyansauqi.efishery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.rememberNavController
import com.zuhriyansauqi.efishery.core.AppNavGraph
import com.zuhriyansauqi.efishery.core_ui.ui.theme.EfisheryTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      EfisheryTheme {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
      }
    }
  }
}
