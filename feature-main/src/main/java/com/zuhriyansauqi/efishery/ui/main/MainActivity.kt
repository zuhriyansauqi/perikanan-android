package com.zuhriyansauqi.efishery.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.zuhriyansauqi.efishery.core_ui.ui.EfisheryTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      EfisheryTheme {
        Scaffold(
          topBar = {
            TopAppBar(
              title = {
                Text(text = "Hello world")
              }
            )
          },
          floatingActionButtonPosition = FabPosition.End,
          floatingActionButton = {
            FloatingActionButton(onClick = {}) {
              Text("X")
            }
          },
        ) { paddingValues ->
          Column(
            modifier = Modifier
              .fillMaxSize()
              .padding(bottom = paddingValues.calculateBottomPadding())
          ) {

          }
        }
      }
    }
  }
}
