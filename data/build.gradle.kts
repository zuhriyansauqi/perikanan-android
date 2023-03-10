plugins {
  androidLibrary
  kotlinAndroid
}

android {
  namespace = "com.zuhriyansauqi.efishery.data"
  compileSdk = appConfig.compileSdkVersion

  defaultConfig {
    minSdk = appConfig.minSdkVersion
    targetSdk = appConfig.targetSdkVersion

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
  }

  testOptions {
    unitTests {
      isReturnDefaultValues = true
      isIncludeAndroidResources = true
    }
  }
}

dependencies {
  implementation(domain)
  implementation(core)

  implementation(deps.androidx.coreKtx)
  implementation(deps.coroutines.core)
  implementation(deps.timber)

  implementation(deps.koin.core)

  implementation(platform(deps.squareup.bom))

  implementation(deps.squareup.retrofit)
  implementation(deps.squareup.moshiKotlin)
  implementation(deps.squareup.converterMoshi)
  implementation(deps.squareup.loggingInterceptor)
  testImplementation(deps.squareup.okHttp)

  addUnitTest()
  testImplementation(deps.test.squareup.mockWebServer)
  testImplementation(deps.test.json)
}
