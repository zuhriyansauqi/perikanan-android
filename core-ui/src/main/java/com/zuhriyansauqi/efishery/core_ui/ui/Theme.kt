@file:Suppress("unused", "SpellCheckingInspection")

package com.zuhriyansauqi.efishery.core_ui.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.zuhriyansauqi.efishery.core_ui.components.SetupStatusBarColor

private val LightColorsScheme = lightColorScheme(
  primary = md_theme_light_primary,
  onPrimary = md_theme_light_on_primary,
  primaryContainer = md_theme_light_primary_container,
  onPrimaryContainer = md_theme_light_on_primary_container,

  secondary = md_theme_light_secondary,
  onSecondary = md_theme_light_on_secondary,
  secondaryContainer = md_theme_light_secondary_container,
  onSecondaryContainer = md_theme_light_on_secondary_container,

  tertiary = md_theme_light_tertiary,
  onTertiary = md_theme_light_on_tertiary,
  tertiaryContainer = md_theme_light_tertiary_container,
  onTertiaryContainer = md_theme_light_on_tertiary_container,

  error = md_theme_light_error,
  onError = md_theme_light_on_error,
  errorContainer = md_theme_light_error_container,
  onErrorContainer = md_theme_light_on_error_container,

  background = md_theme_light_background,
  onBackground = md_theme_light_on_background,

  surface = md_theme_light_surface,
  onSurface = md_theme_light_on_surface,
  surfaceVariant = md_theme_light_surface_variant,
  onSurfaceVariant = md_theme_light_on_surface_variant,

  outline = md_theme_light_outline,
)

private val DarkColorsScheme = darkColorScheme(
  primary = md_theme_dark_primary,
  onPrimary = md_theme_dark_on_primary,
  primaryContainer = md_theme_dark_primary_container,
  onPrimaryContainer = md_theme_dark_on_primary_container,

  secondary = md_theme_dark_secondary,
  onSecondary = md_theme_dark_on_secondary,
  secondaryContainer = md_theme_dark_secondary_container,
  onSecondaryContainer = md_theme_dark_on_secondary_container,

  tertiary = md_theme_dark_tertiary,
  onTertiary = md_theme_dark_on_tertiary,
  tertiaryContainer = md_theme_dark_tertiary_container,
  onTertiaryContainer = md_theme_dark_on_tertiary_container,

  error = md_theme_dark_error,
  onError = md_theme_dark_on_error,
  errorContainer = md_theme_dark_error_container,
  onErrorContainer = md_theme_dark_on_error_container,

  background = md_theme_dark_background,
  onBackground = md_theme_dark_on_background,

  surface = md_theme_dark_surface,
  onSurface = md_theme_dark_on_surface,
  surfaceVariant = md_theme_dark_surface_variant,
  onSurfaceVariant = md_theme_dark_on_surface_variant,

  outline = md_theme_dark_outline,
)

@Composable
fun EfisheryTheme(
  useDarkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable() () -> Unit
) {
  val colorSchemecolors =
    if (!useDarkTheme) {
      LightColorsScheme
    } else {
      DarkColorsScheme
    }

  MaterialTheme(
    colorScheme = colorSchemecolors,
    typography = EfisheryTyphograpy,
  ) {
    SetupStatusBarColor()
    content()
  }
}
