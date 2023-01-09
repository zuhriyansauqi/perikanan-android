package com.zuhriyansauqi.efishery.ui.main

import androidx.compose.material3.ExperimentalMaterial3Api
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

@ExperimentalMaterial3Api
@JvmField
val mainModule = module {
  viewModelOf(::MainVM)

  single<MainFeatureScreen> { MainFeatureScreenImpl() }
}

