package com.zuhriyansauqi.efishery.data.remote.service

import com.zuhriyansauqi.efishery.data.remote.dto.SizeDto
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface SizeApiService {
  @GET("v1/storages/5e1edf521073e315924ceab4/option_size")
  suspend fun getSizes(
    @Query("limit") limit: Int,
    @Query("offset") offset: Int,
  ): List<SizeDto>

  companion object {
    operator fun invoke(retrofit: Retrofit) = retrofit.create<SizeApiService>()
  }
}
