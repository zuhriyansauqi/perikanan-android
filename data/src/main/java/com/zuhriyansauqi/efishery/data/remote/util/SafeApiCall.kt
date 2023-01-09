package com.zuhriyansauqi.efishery.data.remote.util

import com.zuhriyansauqi.efishery.core.dispatchers.AppCoroutineDispatchers
import com.zuhriyansauqi.efishery.domain.model.ResultWrapper
import java.io.IOException
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun <T> safeApiCall(
  dispatchers: AppCoroutineDispatchers,
  apiCall: suspend () -> T
): ResultWrapper<T> {
  return withContext(dispatchers.io) {
    try {
      ResultWrapper.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
      when (throwable) {
        is IOException -> ResultWrapper.NetworkError
        is HttpException -> {
          val code = throwable.code()
          val message = throwable.stackTraceToString()
          ResultWrapper.GenericError(code, message)
        }
        else -> ResultWrapper.GenericError(null, null)
      }
    }
  }
}
