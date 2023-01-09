package com.zuhriyansauqi.efishery.ui.main

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zuhriyansauqi.efishery.core.exception.GenericErrorException
import com.zuhriyansauqi.efishery.core.exception.NetworkErrorException
import com.zuhriyansauqi.efishery.domain.model.Fishery
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import com.zuhriyansauqi.efishery.domain.usecase.fishery.GetFisheries

internal const val MAIN_PAGING_LIMIT = 10

class MainPagingSource(
  private val getFisheries: GetFisheries
) : PagingSource<Int, Fishery>() {
  override fun getRefreshKey(state: PagingState<Int, Fishery>): Int? {
    return null
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Fishery> {
    return try {
      val page = params.key ?: 1
      when (val response = getFisheries(limit = MAIN_PAGING_LIMIT, offset = (page - 1) * MAIN_PAGING_LIMIT)) {
        is ResultWrapper.Success -> LoadResult.Page(
          data = response.value,
          prevKey = null,
          nextKey = if (response.value.isNotEmpty()) page + 1 else null,
        )
        is ResultWrapper.GenericError -> LoadResult.Error(
          throwable = GenericErrorException(
            code = response.code,
            message = response.message
          )
        )
        is ResultWrapper.NetworkError -> LoadResult.Error(
          throwable = NetworkErrorException()
        )
      }
    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }
}
