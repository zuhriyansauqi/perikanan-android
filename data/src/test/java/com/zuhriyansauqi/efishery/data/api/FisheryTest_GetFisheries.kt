package com.zuhriyansauqi.efishery.data.api

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.HttpException

class FisheryTest_GetFisheries : FisheryTestFixture() {
  @Test
  fun `given response is success should return correct DTO Response`() = runBlocking {
    server.respondWithSuccess(successResponse)

    val actualDto = api.getFisheries(10, 0)

    Assert.assertTrue(server.isPathEquals("/v1/storages/5e1edf521073e315924ceab4/list?limit=10&offset=0&search="))
    Assert.assertTrue(actualDto.size == 2)
    Assert.assertTrue(actualDto[0].commodity == "GURAME")

  }

  @Test(expected = HttpException::class)
  fun `given request is failed should throw HTTP Exception`() = runBlocking {
    server.responseWithFailed(withResponseCode = 500, withResponseBody = "")

    api.getFisheries(10, 0)
    Unit
  }

  companion object {
    val successResponse = """
      [
        {
          "uuid": "289fbbd5-202f-4dad-ac54-a39c9bf44a3b",
          "komoditas": "GURAME",
          "area_provinsi": "BANTEN",
          "area_kota": "PANDEGLANG",
          "size": "140",
          "price": "69000",
          "tgl_parsed": "2022-01-14T23:37:19Z",
          "timestamp": "1642203439707"
        },
        {
          "uuid": "41b912df-5e48-47da-a1a7-d28702aad79b",
          "komoditas": "LELE",
          "area_provinsi": "KALIMANTAN TIMUR",
          "area_kota": "BORNEO",
          "size": "200",
          "price": "16000",
          "tgl_parsed": "2022-01-15T03:17:08Z",
          "timestamp": "1642216628334"
        }
       ]
    """.trimIndent()
  }
}
