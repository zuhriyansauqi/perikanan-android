package com.zuhriyansauqi.efishery.data.repository

import com.zuhriyansauqi.efishery.data.remote.util.safeApiCall
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
class FisheryRepositoryTest_DeleteFishert : FisheryRepositoryTestFixture() {
  @Before
  fun setUp() {
    mockkStatic("com.zuhriyansauqi.efishery.data.remote.util.SafeApiCallKt")
  }

  @Test
  fun `given api result is correct when deleteFishery called should return domain model correctly`() =
    testScope.runTest {
      coEvery { api.deleteFishery(any()) } returns Any()
      every { dispatchers.io } returns testDispatcher

      repository.deleteFishery(uuid = "1234")

      coVerify { safeApiCall<Any>(any(), any()) }
      coVerify { api.deleteFishery(any()) }
    }

  @After
  fun tearDown() {
    unmockkAll()
  }
}
