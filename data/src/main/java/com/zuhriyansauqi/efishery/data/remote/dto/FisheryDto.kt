package com.zuhriyansauqi.efishery.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FisheryDto(
  val uuid: String?,
  @Json(name = "komoditas")
  val commodity: String?,
  @Json(name = "area_provinsi")
  val province: String?,
  @Json(name = "area_kota")
  val city: String?,
  val size: String?,
  val price: String?,
  val timestamp: String?,
)
