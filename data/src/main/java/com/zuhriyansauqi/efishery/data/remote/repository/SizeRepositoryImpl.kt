package com.zuhriyansauqi.efishery.data.remote.repository

import com.zuhriyansauqi.efishery.core.dispatchers.AppCoroutineDispatchers
import com.zuhriyansauqi.efishery.data.remote.dto.SizeDto
import com.zuhriyansauqi.efishery.data.remote.service.SizeApiService
import com.zuhriyansauqi.efishery.data.remote.util.safeApiCall
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import com.zuhriyansauqi.efishery.domain.model.Size
import com.zuhriyansauqi.efishery.domain.repository.SizeRepository

class SizeRepositoryImpl(
  private val apiService: SizeApiService,
  private val dispatchers: AppCoroutineDispatchers,
) : SizeRepository {
  override suspend fun getSizes(limit: Int, offset: Int): ResultWrapper<List<Size>> {
    return safeApiCall(dispatchers) {
      apiService.getSizes(limit, offset)
        .mapToDomainModel()
    }
  }

  private fun List<SizeDto>.mapToDomainModel() = map {
    Size(
      size = it.size
    )
  }
}
