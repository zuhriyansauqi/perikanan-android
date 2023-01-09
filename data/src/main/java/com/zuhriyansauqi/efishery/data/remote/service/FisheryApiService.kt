package com.zuhriyansauqi.efishery.data.remote.service

import com.zuhriyansauqi.efishery.data.remote.dto.FisheryDto
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.*

interface FisheryApiService {
  @GET("v1/storages/5e1edf521073e315924ceab4/list")
  suspend fun getFisheries(
    @Query("limit") limit: Int,
    @Query("offset") offset: Int,
    @Query("search") search: String = "",
  ): List<FisheryDto>

  @PUT("v1/storages/5e1edf521073e315924ceab4/list")
  suspend fun updateFishery(
    @Body body: RequestBody
  ): Any

  @HTTP(method = "DELETE", path = "v1/storages/5e1edf521073e315924ceab4/list", hasBody = true)
  suspend fun deleteFishery(
    @Body body: RequestBody
  ): Any

  @POST("v1/storages/5e1edf521073e315924ceab4/list")
  suspend fun addFishery(
    @Body body: RequestBody
  ): Any

  companion object {
    operator fun invoke(retrofit: Retrofit) = retrofit.create<FisheryApiService>()
  }
}
