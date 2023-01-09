package com.zuhriyansauqi.efishery.domain.usecase.fishery

import com.zuhriyansauqi.efishery.domain.repository.FisheryRepository

class UpdateFishery(
  private val repository: FisheryRepository,
) {
  suspend operator fun invoke(uuid: String, params: Map<String, Any>) =
    repository.updateFishery(uuid, params)
}
