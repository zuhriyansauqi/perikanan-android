package com.zuhriyansauqi.efishery.core.extensions

import java.util.*

fun String.capitalizeEachWords() =
  this
    .lowercase()
    .replaceFirstChar {
      if (it.isLowerCase()) it.titlecase(
        Locale("in", "ID")
      ) else it.toString()
    }
