package com.zuhriyansauqi.efishery.data.remote.repository

import com.zuhriyansauqi.efishery.core.dispatchers.AppCoroutineDispatchers
import com.zuhriyansauqi.efishery.data.remote.dto.AreaDto
import com.zuhriyansauqi.efishery.data.remote.service.AreaApiService
import com.zuhriyansauqi.efishery.data.remote.util.safeApiCall
import com.zuhriyansauqi.efishery.domain.model.Area
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import com.zuhriyansauqi.efishery.domain.repository.AreaRepository


class AreaRepositoryImpl(
  private val apiService: AreaApiService,
  private val dispatchers: AppCoroutineDispatchers,
) : AreaRepository {
  override suspend fun getAreas(limit: Int, offset: Int): ResultWrapper<List<Area>> {
    return safeApiCall(dispatchers) {
      apiService.getAreas(limit, offset)
        .mapToDomainModel()
    }
  }

  private fun List<AreaDto>.mapToDomainModel() = map {
    Area(
      province = it.province,
      city = it.city
    )
  }
}
