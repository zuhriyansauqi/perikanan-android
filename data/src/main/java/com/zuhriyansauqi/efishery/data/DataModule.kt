package com.zuhriyansauqi.efishery.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.zuhriyansauqi.efishery.data.remote.repository.AreaRepositoryImpl
import com.zuhriyansauqi.efishery.data.remote.repository.FisheryRepositoryImpl
import com.zuhriyansauqi.efishery.data.remote.repository.SizeRepositoryImpl
import com.zuhriyansauqi.efishery.data.remote.service.AreaApiService
import com.zuhriyansauqi.efishery.data.remote.service.FisheryApiService
import com.zuhriyansauqi.efishery.data.remote.service.SizeApiService
import com.zuhriyansauqi.efishery.domain.repository.AreaRepository
import com.zuhriyansauqi.efishery.domain.repository.FisheryRepository
import com.zuhriyansauqi.efishery.domain.repository.SizeRepository
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val BASE_URL_QUALIFIER = named("BASE_URL")

@ExperimentalStdlibApi
@JvmField
val dataModule = module {
  singleOf(FisheryApiService::invoke)
  singleOf(AreaApiService::invoke)
  singleOf(SizeApiService::invoke)

  single {
    provideRetrofit(
      baseUrl = get(BASE_URL_QUALIFIER),
      moshi = get(),
      client = get()
    )
  }

  single { provideMoshi() }

  single { provideOkHttpClient() }

  factory(BASE_URL_QUALIFIER) { "https://stein.efishery.com/" }

  single<FisheryRepository> {
    FisheryRepositoryImpl(
      apiService = get(),
      dispatchers = get(),
    )
  }

  single<SizeRepository> {
    SizeRepositoryImpl(
      apiService = get(),
      dispatchers = get(),
    )
  }

  single<AreaRepository> {
    AreaRepositoryImpl(
      apiService = get(),
      dispatchers = get(),
    )
  }
}

private fun provideMoshi(): Moshi {
  return Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
}

private fun provideRetrofit(baseUrl: String, moshi: Moshi, client: OkHttpClient): Retrofit {
  return Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(baseUrl)
    .build()
}

private fun provideOkHttpClient(): OkHttpClient {
  return OkHttpClient.Builder()
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .addInterceptor(
      HttpLoggingInterceptor()
        .apply { level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE }
    )
    .build()
}
