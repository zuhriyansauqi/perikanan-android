plugins {
  androidLibrary
  kotlinAndroid
}

android {
  namespace = "com.zuhriyansauqi.efishery.ui.main"
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

  buildFeatures { compose = true }

  composeOptions {
    kotlinCompilerExtensionVersion = kotlinCompilerExtVersion
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
  implementation(coreUi)

  implementation(deps.androidx.coreKtx)
  implementation(deps.androidx.paging)
  implementation(deps.androidx.pagingCompose)
  implementation(deps.coroutines.android)
  implementation(deps.koin.android)
  implementation(deps.koin.compose)

  addCompose()
  implementation(deps.icons.feather)

  implementation(deps.timber)

  addUnitTest()
}
