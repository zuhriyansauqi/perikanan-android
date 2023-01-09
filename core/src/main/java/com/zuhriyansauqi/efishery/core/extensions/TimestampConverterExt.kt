package com.zuhriyansauqi.efishery.core.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.toUniversalDateString() : String {
  val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
  val date = Date(this)
  return dateFormat.format(date)
}
