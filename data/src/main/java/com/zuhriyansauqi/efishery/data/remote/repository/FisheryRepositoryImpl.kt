package com.zuhriyansauqi.efishery.data.remote.repository

import com.zuhriyansauqi.efishery.core.dispatchers.AppCoroutineDispatchers
import com.zuhriyansauqi.efishery.core.extensions.toUniversalDateString
import com.zuhriyansauqi.efishery.data.remote.dto.FisheryDto
import com.zuhriyansauqi.efishery.data.remote.service.FisheryApiService
import com.zuhriyansauqi.efishery.data.remote.util.createJsonRequestBody
import com.zuhriyansauqi.efishery.data.remote.util.safeApiCall
import com.zuhriyansauqi.efishery.domain.model.Fishery
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import com.zuhriyansauqi.efishery.domain.repository.FisheryRepository
import org.json.JSONObject

@ExperimentalStdlibApi
class FisheryRepositoryImpl(
  private val apiService: FisheryApiService,
  private val dispatchers: AppCoroutineDispatchers,
) : FisheryRepository {
  override suspend fun getFisheries(limit: Int, offset: Int): ResultWrapper<List<Fishery>> {
    return safeApiCall(dispatchers) {
      apiService.getFisheries(limit, offset)
        .mapToDomainModel()
    }
  }

  override suspend fun searchFisheries(
    commodity: String,
    limit: Int,
    offset: Int,
  ): ResultWrapper<List<Fishery>> {
    return safeApiCall(dispatchers) {
      val searchJson = JSONObject(
        mapOf(
          "komoditas" to commodity
        )
      ).toString()
      apiService.getFisheries(limit, offset, searchJson)
        .mapToDomainModel()
    }
  }

  override suspend fun deleteFishery(uuid: String): ResultWrapper<Unit> {
    return safeApiCall(dispatchers) {
      val requestBody = createJsonRequestBody(
        "condition" to JSONObject(mapOf("uuid" to uuid)),
        "limit" to 1
      )
      apiService.deleteFishery(body = requestBody)
    }
  }

  override suspend fun updateFishery(uuid: String, params: Map<String, Any>): ResultWrapper<Any> {
    return safeApiCall(dispatchers) {
      val requestBody = createJsonRequestBody(
        "condition" to JSONObject(mapOf("uuid" to uuid)),
        "set" to JSONObject(params),
        "limit" to 1
      )
      apiService.updateFishery(body = requestBody)
    }
  }

  override suspend fun addFishery(fishery: Fishery): ResultWrapper<Any> {
    return safeApiCall(dispatchers) {
      apiService.addFishery(body = fishery.toRequestBody())
    }
  }

  private fun List<FisheryDto>.mapToDomainModel() = map {
    Fishery(
      uuid = it.uuid,
      commodity = it.commodity,
      province = it.province,
      city = it.city,
      size = it.size?.toInt(),
      price = it.price?.toInt(),
      timestamp = it.timestamp?.toLong(),
    )
  }

  private fun Fishery.toRequestBody() = createJsonRequestBody(
    JSONObject(
      mapOf(
        "uuid" to uuid,
        "komoditas" to commodity,
        "area_provinsi" to province,
        "area_kota" to city,
        "size" to size.toString(),
        "price" to price.toString(),
        "tgl_parsed" to timestamp!!.toUniversalDateString(),
        "timestamp" to timestamp.toString()
      )
    )
  )
}
