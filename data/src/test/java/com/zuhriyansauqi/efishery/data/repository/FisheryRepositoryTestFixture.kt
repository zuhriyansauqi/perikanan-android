package com.zuhriyansauqi.efishery.data.repository

import com.zuhriyansauqi.efishery.core.dispatchers.AppCoroutineDispatchers
import com.zuhriyansauqi.efishery.data.remote.repository.FisheryRepositoryImpl
import com.zuhriyansauqi.efishery.data.remote.service.FisheryApiService
import com.zuhriyansauqi.efishery.domain.repository.FisheryRepository
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestScope

@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
open class FisheryRepositoryTestFixture {
  val api: FisheryApiService = mockk()
  val dispatchers: AppCoroutineDispatchers = mockk()
  val repository: FisheryRepository = FisheryRepositoryImpl(api, dispatchers)

  val testDispatcher = StandardTestDispatcher(TestCoroutineScheduler())
  val testScope = TestScope(testDispatcher)
}
