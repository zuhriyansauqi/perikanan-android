package com.zuhriyansauqi.efishery.domain

import com.zuhriyansauqi.efishery.domain.usecase.area.GetAreas
import com.zuhriyansauqi.efishery.domain.usecase.fishery.AddFishery
import com.zuhriyansauqi.efishery.domain.usecase.fishery.DeleteFishery
import com.zuhriyansauqi.efishery.domain.usecase.fishery.GetFisheries
import com.zuhriyansauqi.efishery.domain.usecase.fishery.UpdateFishery
import com.zuhriyansauqi.efishery.domain.usecase.size.GetSizes
import org.koin.dsl.module

@JvmField
val domainModule = module {
  single { GetFisheries(repository = get()) }
  single { DeleteFishery(repository = get()) }
  single { UpdateFishery(repository = get()) }
  single { AddFishery(repository = get()) }

  single { GetSizes(repository = get()) }

  single { GetAreas(repository = get()) }
}
