package com.zuhriyansauqi.efishery.initializer

import android.content.Context
import androidx.startup.Initializer
import com.zuhriyansauqi.efishery.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {
  override fun create(context: Context) {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
    Timber.d("TimberInitializer...")
  }

  override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
