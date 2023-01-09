package com.zuhriyansauqi.efishery.domain.usecase.fishery

import com.zuhriyansauqi.efishery.domain.repository.FisheryRepository

class GetFisheries(
  private val repository: FisheryRepository
) {
  suspend operator fun invoke(limit: Int, offset: Int) =
    repository.getFisheries(limit, offset)
}
