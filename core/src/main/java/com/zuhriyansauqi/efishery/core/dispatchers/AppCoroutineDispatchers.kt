package com.zuhriyansauqi.efishery.core.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface AppCoroutineDispatchers {
  val main: CoroutineDispatcher
  val mainImmediate: CoroutineDispatcher
  val io: CoroutineDispatcher
}
