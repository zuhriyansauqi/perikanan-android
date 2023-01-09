package com.zuhriyansauqi.efishery.ui.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import com.zuhriyansauqi.efishery.domain.usecase.fishery.DeleteFishery
import com.zuhriyansauqi.efishery.domain.usecase.fishery.GetFisheries
import kotlinx.coroutines.launch

class MainVM(
  private val getFisheries: GetFisheries,
  private val deleteFishery: DeleteFishery,
) : ViewModel() {
  private val fisheryPager = Pager(
    PagingConfig(pageSize = MAIN_PAGING_LIMIT)
  ) {
    MainPagingSource(getFisheries)
  }.flow.cachedIn(viewModelScope)

  @Composable
  fun fisheries() = fisheryPager.collectAsLazyPagingItems()

  fun delete(uuid: String) {
    viewModelScope.launch {
      when (val response = deleteFishery(uuid)) {
        is ResultWrapper.Success -> println(response.value)
        else -> println("error delete $response")
      }
    }
  }
}
