package com.zuhriyansauqi.efishery.domain.repository

import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import com.zuhriyansauqi.efishery.domain.model.Size

interface SizeRepository {
  suspend fun getSizes(limit: Int, offset: Int): ResultWrapper<List<Size>>
}
