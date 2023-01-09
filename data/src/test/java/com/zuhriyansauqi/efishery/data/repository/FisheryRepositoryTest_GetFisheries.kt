package com.zuhriyansauqi.efishery.data.repository

import com.zuhriyansauqi.efishery.data.remote.dto.FisheryDto
import com.zuhriyansauqi.efishery.data.remote.util.safeApiCall
import com.zuhriyansauqi.efishery.domain.model.Fishery
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalStdlibApi
@ExperimentalCoroutinesApi
class FisheryRepositoryTest_GetFisheries : FisheryRepositoryTestFixture() {
  @Before
  fun setUp() {
    mockkStatic("com.zuhriyansauqi.efishery.data.remote.util.SafeApiCallKt")
  }

  @Test
  fun `given api result is correct when getFisheries called should return domain model correctly`() =
    testScope.runTest {
      val apiResult =
        listOf(
          FisheryDto(
            uuid = "289fbbd5-202f-4dad-ac54-a39c9bf44a3b",
            commodity = "GURAME",
            province = "BANTEN",
            city = "PANDEGLANG",
            size = "140",
            price = "69000",
            timestamp = "1642203439707",
          ),
          FisheryDto(
            uuid = "41b912df-5e48-47da-a1a7-d28702aad79b",
            commodity = "LELE",
            province = "KALIMANTAN TIMUR",
            city = "BORNEO",
            size = "200",
            price = "16000",
            timestamp = "1642216628334",
          ),
        )

      coEvery { api.getFisheries(any(), any(), any()) } returns apiResult
      every { dispatchers.io } returns testDispatcher

      val actualResult = repository.getFisheries(limit = 10, offset = 0)

      val expectedResult = ResultWrapper.Success(
        value = listOf(
          Fishery(
            uuid = "289fbbd5-202f-4dad-ac54-a39c9bf44a3b",
            commodity = "GURAME",
            province = "BANTEN",
            city = "PANDEGLANG",
            size = 140,
            price = 69000,
            timestamp = 1642203439707,
          ),
          Fishery(
            uuid = "41b912df-5e48-47da-a1a7-d28702aad79b",
            commodity = "LELE",
            province = "KALIMANTAN TIMUR",
            city = "BORNEO",
            size = 200,
            price = 16000,
            timestamp = 1642216628334,
          ),
        )
      )

      coVerify { safeApiCall<List<Fishery>>(any(), any()) }
      coVerify { api.getFisheries(any(), any(), any()) }
      Assert.assertEquals(expectedResult, actualResult)
    }

  @After
  fun tearDown() {
    unmockkAll()
  }
}
