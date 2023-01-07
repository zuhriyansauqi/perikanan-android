// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id("com.android.application") version androidVersion apply false
  id("com.android.library") version androidVersion apply false
  id("org.jetbrains.kotlin.android") version kotlinVersion apply false
  id("com.google.gms.google-services") version googleServiceVersion apply false
  id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
}
