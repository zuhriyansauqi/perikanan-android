package com.zuhriyansauqi.efishery.data.api

import com.zuhriyansauqi.efishery.data.SteinMockWebServerTestRule
import com.zuhriyansauqi.efishery.data.remote.service.FisheryApiService
import org.junit.Rule

open class FisheryTestFixture {
  @get:Rule
  val server = SteinMockWebServerTestRule()
  val api = server.createApi(FisheryApiService::class.java)
}
