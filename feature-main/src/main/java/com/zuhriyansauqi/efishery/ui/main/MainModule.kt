package com.zuhriyansauqi.efishery.ui.main

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

@JvmField
val mainModule = module {
  viewModelOf(::MainVM)
}
