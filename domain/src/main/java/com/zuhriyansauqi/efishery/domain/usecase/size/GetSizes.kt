package com.zuhriyansauqi.efishery.domain.usecase.size

import com.zuhriyansauqi.efishery.domain.repository.SizeRepository

class GetSizes(
  private val repository: SizeRepository
) {
  suspend operator fun invoke(limit: Int, offset: Int) =
    repository.getSizes(limit, offset)
}
