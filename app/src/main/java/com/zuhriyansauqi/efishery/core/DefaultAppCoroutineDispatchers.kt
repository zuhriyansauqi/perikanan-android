package com.zuhriyansauqi.efishery.core

import com.zuhriyansauqi.efishery.core.dispatchers.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DefaultAppCoroutineDispatchers : AppCoroutineDispatchers {
  override val main: CoroutineDispatcher
    get() = Dispatchers.Main

  override val mainImmediate: CoroutineDispatcher
    get() = Dispatchers.Main.immediate

  override val io: CoroutineDispatcher
    get() = Dispatchers.IO
}
