plugins {
  androidApplication
  kotlinAndroid
  googleService
}

android {
  namespace = "com.zuhriyansauqi.efishery"
  compileSdk = appConfig.compileSdkVersion

  defaultConfig {
    applicationId = appConfig.applicationId
    minSdk = appConfig.minSdkVersion
    targetSdk = appConfig.targetSdkVersion
    versionCode = appConfig.versionCode
    versionName = appConfig.versionName

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    unitTests.isIncludeAndroidResources = true
    unitTests.isReturnDefaultValues = true
  }
}

dependencies {
  implementation(core)
  implementation(coreUi)
  implementation(featureMain)

  implementation(deps.androidx.coreKtx)
  implementation(deps.androidx.material)
  implementation(deps.androidx.startup)

  implementation(deps.coroutines.android)
  implementation(deps.koin.android)

  addCompose()

  implementation(platform(deps.firebase.bom))
  implementation(deps.firebase.analytics)

  implementation(deps.timber)

  testImplementation(deps.test.junit)
  androidTestImplementation(deps.test.androidx.junit)
  androidTestImplementation(deps.test.androidx.core)
  androidTestImplementation(deps.test.androidx.espresso.core)

  addUnitTest()
  testImplementation(deps.koin.testJunit4)
  testImplementation(deps.koin.test)
}
