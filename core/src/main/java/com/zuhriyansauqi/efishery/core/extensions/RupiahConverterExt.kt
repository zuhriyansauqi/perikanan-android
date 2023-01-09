package com.zuhriyansauqi.efishery.core.extensions

import java.text.NumberFormat
import java.util.*

fun Int.convertRupiah(): String {
  val localId = Locale("in", "ID")
  val formatter = NumberFormat.getCurrencyInstance(localId)
  return formatter.format(this)
}
