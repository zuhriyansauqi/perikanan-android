package com.zuhriyansauqi.efishery.domain.usecase.fishery

import com.zuhriyansauqi.efishery.domain.model.Fishery
import com.zuhriyansauqi.efishery.domain.repository.FisheryRepository

class AddFishery(
  private val repository: FisheryRepository
) {
  suspend operator fun invoke(fishery: Fishery) =
    repository.addFishery(fishery)
}
