package com.zuhriyansauqi.efishery

import android.app.Application
import androidx.compose.material3.ExperimentalMaterial3Api
import com.zuhriyansauqi.efishery.core.coreModule
import com.zuhriyansauqi.efishery.data.dataModule
import com.zuhriyansauqi.efishery.domain.domainModule
import com.zuhriyansauqi.efishery.ui.main.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@ExperimentalMaterial3Api
@ExperimentalStdlibApi
@JvmField
val allModules = listOf(
  coreModule,
  dataModule,
  domainModule,
  mainModule,
)

@ExperimentalMaterial3Api
@ExperimentalStdlibApi
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
