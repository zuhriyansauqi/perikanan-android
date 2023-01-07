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
  implementation(coreUi)

  implementation(deps.androidx.coreKtx)

  addCompose()

  implementation(deps.timber)

  addUnitTest()
}
