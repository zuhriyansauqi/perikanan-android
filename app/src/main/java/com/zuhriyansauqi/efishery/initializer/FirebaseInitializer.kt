package com.zuhriyansauqi.efishery.initializer

import android.content.Context
import androidx.startup.Initializer
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class FirebaseInitializer : Initializer<Unit> {
  override fun create(context: Context) {
    Firebase.initialize(context = context)
  }

  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
