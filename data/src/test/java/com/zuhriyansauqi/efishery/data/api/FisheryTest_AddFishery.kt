package com.zuhriyansauqi.efishery.data.api

import com.zuhriyansauqi.efishery.core.extensions.toUniversalDateString
import com.zuhriyansauqi.efishery.data.remote.util.createJsonRequestBody
import java.util.*
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import org.junit.Assert
import org.junit.Test
import retrofit2.HttpException

class FisheryTest_AddFishery : FisheryTestFixture() {
  @Test
  fun `given response is success should return correct DTO Response`() = runBlocking {
    server.respondWithSuccess(successResponse)

    api.addFishery(requestBody)

    Assert.assertTrue(server.isPathEquals("/v1/storages/5e1edf521073e315924ceab4/list"))
  }

  @Test(expected = HttpException::class)
  fun `given request is failed should throw HTTP Exception`() = runBlocking {
    server.responseWithFailed(withResponseCode = 500, withResponseBody = "")

    api.addFishery(requestBody)
    Unit
  }

  companion object {
    val requestBody = createJsonRequestBody(
      JSONObject(
        mapOf(
          "uuid" to UUID.randomUUID().toString(),
          "komoditas" to "GURAME",
          "area_provinsi" to "BANTEN",
          "area_kota" to "PANDEGLANG",
          "size" to 140.toString(),
          "price" to 69000.toString(),
          "tgl_parsed" to 1673267119L.toUniversalDateString(),
          "timestamp" to 1673267119L.toString()
        )
      )
    )

    val successResponse = """
      {
        "updatedRange": "Sheet1!A6:D6"
      }
    """.trimIndent()
  }
}
