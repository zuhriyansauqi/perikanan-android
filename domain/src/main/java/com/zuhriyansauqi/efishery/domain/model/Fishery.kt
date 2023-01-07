package com.zuhriyansauqi.efishery.domain.model

data class Fishery(
  val uuid: String,
  val commodity: String,
  val province: String,
  val city: String,
  val size: Int,
  val dateParsed: String,
  val timestamp: Long,
)
