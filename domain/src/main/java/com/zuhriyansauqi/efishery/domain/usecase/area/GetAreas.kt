package com.zuhriyansauqi.efishery.domain.usecase.area

import com.zuhriyansauqi.efishery.domain.repository.AreaRepository

class GetAreas(
  private val repository: AreaRepository
) {
  suspend operator fun invoke(limit: Int, offset: Int) =
    repository.getAreas(limit, offset)
}
