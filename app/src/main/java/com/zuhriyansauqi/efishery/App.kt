package com.zuhriyansauqi.efishery

import android.app.Application
import com.zuhriyansauqi.efishery.core.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@JvmField
val allModules = listOf(
  coreModule,
)

class App : Application() {
  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@App)
      androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
      modules(allModules)
    }
  }
}
