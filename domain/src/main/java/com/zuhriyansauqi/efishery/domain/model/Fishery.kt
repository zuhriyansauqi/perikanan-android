package com.zuhriyansauqi.efishery.domain.model

import com.zuhriyansauqi.efishery.core.extensions.capitalizeEachWords
import com.zuhriyansauqi.efishery.core.extensions.convertRupiah
import java.util.*

data class Fishery(
  val uuid: String?,
  val commodity: String?,
  val province: String?,
  val city: String?,
  val size: Int?,
  val price: Int?,
  val timestamp: Long?,
) {
  val commodityFormatted: String
    get() = commodity?.trim()?.capitalizeEachWords() ?: "N/A"

  val priceFormatted: String
    get() = price?.let { "${it.convertRupiah()} / $size item" } ?: "N/A"

  val location: String
    get() =
      if (city != null && price != null)
        "${city.trim().capitalizeEachWords()}, ${province?.trim()?.capitalizeEachWords()}"
      else "N/A"

  companion object {
    fun create(
      commodity: String,
      province: String,
      city: String,
      size: Int,
      price: Int,
    ) = Fishery(
      uuid = UUID.randomUUID().toString(),
      commodity = commodity,
      province = province,
      city = city,
      size = size,
      price = price,
      timestamp = System.currentTimeMillis()
    )
  }
}
