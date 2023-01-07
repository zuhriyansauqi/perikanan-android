package com.zuhriyansauqi.efishery.core

import com.zuhriyansauqi.efishery.core.dispatchers.AppCoroutineDispatchers
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

@JvmField
val coreModule = module {
  singleOf(::DefaultAppCoroutineDispatchers) { bind<AppCoroutineDispatchers>() }
}
