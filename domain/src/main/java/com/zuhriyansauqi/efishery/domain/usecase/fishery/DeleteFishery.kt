package com.zuhriyansauqi.efishery.domain.usecase.fishery

import com.zuhriyansauqi.efishery.domain.repository.FisheryRepository

class DeleteFishery(
  private val repository: FisheryRepository
) {
  suspend operator fun invoke(uuid: String) =
    repository.deleteFishery(uuid)
}
