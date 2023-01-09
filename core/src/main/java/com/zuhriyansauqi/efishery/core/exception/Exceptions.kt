@file:Suppress("unused")

package com.zuhriyansauqi.efishery.core.exception

class GenericErrorException(
  val code: Int? = null,
  message: String? = null,
) : Exception(message)

class NetworkErrorException : Exception()
