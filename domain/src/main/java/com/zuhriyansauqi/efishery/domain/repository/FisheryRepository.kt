package com.zuhriyansauqi.efishery.domain.repository

import com.zuhriyansauqi.efishery.domain.model.Fishery
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper

interface FisheryRepository {
  suspend fun getFisheries(
    limit: Int,
    offset: Int
  ): ResultWrapper<List<Fishery>>

  suspend fun searchFisheries(
    commodity: String,
    limit: Int,
    offset: Int
  ): ResultWrapper<List<Fishery>>

  suspend fun deleteFishery(
    uuid: String,
  ): ResultWrapper<Any>

  suspend fun updateFishery(
    uuid: String,
    params: Map<String, Any>,
  ): ResultWrapper<Any>

  suspend fun addFishery(
    fishery: Fishery
  ): ResultWrapper<Any>
}
