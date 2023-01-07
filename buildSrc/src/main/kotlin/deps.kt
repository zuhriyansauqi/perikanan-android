@file:Suppress("unused", "ClassName", "SpellCheckingInspection")

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

const val androidVersion = "7.3.1"
const val ktlintVersion = "0.46.1"
const val kotlinVersion = "1.7.21"
const val googleServiceVersion = "4.3.13"
const val kotlinCompilerExtVersion = "1.3.2"

object appConfig {
  const val applicationId = "com.zuhriyansauqi.efishery"

  const val compileSdkVersion = 33
  const val buildToolsVersion = "33.0.1"

  const val minSdkVersion = 21
  const val targetSdkVersion = 33

  private const val MAJOR = 0
  private const val MINOR = 1
  private const val PATCH = 0
  const val versionCode = MAJOR * 10000 + MINOR * 100 + PATCH
  const val versionName = "$MAJOR.$MINOR.$PATCH-SNAPSHOT"
}

object deps {
  object accompanist {
    private const val version = "0.28.0"

    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:$version"
  }

  object androidx {
    const val coreKtx = "androidx.core:core-ktx:1.9.0"
    const val material = "com.google.android.material:material:1.6.1"
    const val startup = "androidx.startup:startup-runtime:1.1.1"
  }

  object arrow {
    private const val version = "1.1.3"
    const val core = "io.arrow-kt:arrow-core:$version"
  }

  object compose {
    private const val version = "2022.12.00"

    const val bom = "androidx.compose:compose-bom:$version"
    const val material3 = "androidx.compose.material3:material3:1.1.0-alpha03"
    const val material3WindowSize = "androidx.compose.material3:material3-window-size-class"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val uiTooling = "androidx.compose.ui:ui-tooling"

    const val activities = "androidx.activity:activity-compose:1.5.1"
    const val viewModels = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
  }

  object coroutines {
    private const val version = "1.6.4"

    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
  }

  object firebase {
    private const val version = "31.1.1"

    const val bom = "com.google.firebase:firebase-bom:$version"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
  }

  object koin {
    private const val version = "3.2.0"

    const val core = "io.insert-koin:koin-core:$version"
    const val android = "io.insert-koin:koin-android:$version"
    const val testJunit4 = "io.insert-koin:koin-test-junit4:$version"
    const val test = "io.insert-koin:koin-test:$version"
  }

  object test {
    const val junit = "junit:junit:4.13.2"

    object compose {
      const val testJunit4 = "androidx.compose.ui:ui-test-junit4"
      const val testManifest = "androidx.compose.ui:ui-test-manifest"
    }

    object androidx {
      const val core = "androidx.test:core-ktx:1.4.0"
      const val junit = "androidx.test.ext:junit-ktx:1.1.3"

      object espresso {
        const val core = "androidx.test.espresso:espresso-core:3.4.0"
      }
    }

    const val mockk = "io.mockk:mockk:1.12.4"
    const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
  }

  const val timber = "com.jakewharton.timber:timber:5.0.1"
}

private typealias PDsS = PluginDependenciesSpec
private typealias PDS = PluginDependencySpec

inline val PDsS.androidApplication: PDS get() = id("com.android.application")
inline val PDsS.androidLibrary: PDS get() = id("com.android.library")
inline val PDsS.kotlinAndroid: PDS get() = id("org.jetbrains.kotlin.android")
inline val PDsS.kotlin: PDS get() = id("kotlin")
inline val PDsS.googleService: PDS get() = id("com.google.gms.google-services")

inline val DependencyHandler.core get() = project(":core")
inline val DependencyHandler.coreUi get() = project(":core-ui")
inline val DependencyHandler.featureMain get() = project(":feature-main")

fun DependencyHandler.addUnitTest(testImplementation: Boolean = true) {
  val configName = if (testImplementation) "testImplementation" else "implementation"

  add(configName, deps.test.junit)
  add(configName, deps.test.mockk)
  add(configName, deps.test.kotlinJUnit)
  add(configName, deps.coroutines.test)
}

fun DependencyHandler.addCompose() {
  val composeBom = platform(deps.compose.bom)
  val configName = "implementation"
  val debugConfigName = "debugImplementation"
  val androidTestConfigName = "androidTestImplementation"

  add(configName, composeBom)
  add(androidTestConfigName, composeBom)

  add(configName, deps.compose.material3)

  add(configName, deps.compose.toolingPreview)
  add(debugConfigName, deps.compose.uiTooling)

  add(androidTestConfigName, deps.test.compose.testJunit4)
  add(debugConfigName, deps.test.compose.testManifest)

  add(configName, deps.compose.material3WindowSize)
  add(configName, deps.compose.activities)
  add(configName, deps.compose.viewModels)
}
