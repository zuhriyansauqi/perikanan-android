package com.zuhriyansauqi.efishery.data.api

import com.zuhriyansauqi.efishery.data.remote.util.createJsonRequestBody
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import org.junit.Assert
import org.junit.Test
import retrofit2.HttpException

class FisheryTest_DeleteFishery : FisheryTestFixture() {
  @Test
  fun `given response is success should return correct DTO Response`() = runBlocking {
    server.respondWithSuccess(successResponse)

    api.deleteFishery(requestBody)

    Assert.assertTrue(server.isPathEquals("/v1/storages/5e1edf521073e315924ceab4/list"))
  }

  @Test(expected = HttpException::class)
  fun `given request is failed should throw HTTP Exception`() = runBlocking {
    server.responseWithFailed(withResponseCode = 500, withResponseBody = "")

    api.deleteFishery(requestBody)
    Unit
  }

  companion object {
    val requestBody = createJsonRequestBody(
      "condition" to JSONObject(mapOf("uuid" to "uuid")),
      "limit" to 1
    )

    val successResponse = """
      {
        "clearedRowsCount": 0
      }
    """.trimIndent()
  }
}
