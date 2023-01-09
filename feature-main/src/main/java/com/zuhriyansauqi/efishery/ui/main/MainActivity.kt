package com.zuhriyansauqi.efishery.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.zuhriyansauqi.efishery.core_ui.ui.theme.EfisheryTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      EfisheryTheme {
        MainScreen()
      }
    }
  }
}
