package com.zuhriyansauqi.efishery.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.concurrent.TimeUnit
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SteinMockWebServerTestRule : TestWatcher() {
  private val server = MockWebServer()

  override fun starting(description: Description?) {
    server.url("/")
    super.starting(description)
  }

  fun respondWithSuccess(withResponseBody: String) {
    respondWith(responseCode = 200, responseBody = withResponseBody)
  }

  fun responseWithFailed(withResponseCode: Int, withResponseBody: String) {
    respondWith(responseCode = withResponseCode, responseBody = withResponseBody)
  }

  fun isPathEquals(expectedPath: String): Boolean {
    val request = server.takeRequest()
    return request.path == expectedPath
  }

  fun <Clazz> createApi(
    clazz: Class<Clazz>,
    baseUrl: String = server.url("/").toString(),
    httpClient: OkHttpClient = OkHttpClient().newBuilder()
      .connectTimeout(30, TimeUnit.SECONDS)
      .callTimeout(30, TimeUnit.SECONDS)
      .readTimeout(30, TimeUnit.SECONDS)
      .writeTimeout(30, TimeUnit.SECONDS)
      .build(),
  ): Clazz = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(
      MoshiConverterFactory.create(
        Moshi.Builder()
          .add(KotlinJsonAdapterFactory())
          .build()
      )
    )
    .client(httpClient)
    .build()
    .create(clazz)

  private fun respondWith(
    responseCode: Int,
    responseBody: String,
    headers: Headers? = null,
  ) {
    val response = MockResponse().apply {
      setResponseCode(responseCode)
      setBody(responseBody)
      headers?.let(::setHeaders)
    }
    server.enqueue(response)
  }
}
