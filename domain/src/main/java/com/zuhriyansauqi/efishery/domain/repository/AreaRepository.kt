package com.zuhriyansauqi.efishery.domain.repository

import com.zuhriyansauqi.efishery.domain.model.Area
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper

interface AreaRepository {
  suspend fun getAreas(limit: Int, offset: Int): ResultWrapper<List<Area>>
}
