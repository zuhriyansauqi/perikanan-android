plugins {
  kotlin
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
  implementation(core)

  implementation(deps.koin.core)
}
