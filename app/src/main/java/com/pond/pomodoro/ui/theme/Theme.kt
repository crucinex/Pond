package com.pond.pomodoro.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = DarkOnBackground,
    primaryContainer = PrimaryDark,
    onPrimaryContainer = SecondaryLight,
    secondary = Secondary,
    onSecondary = DarkBackground,
    secondaryContainer = SecondaryVariant,
    onSecondaryContainer = DarkOnBackground,
    tertiary = AccentPurple,
    onTertiary = DarkOnBackground,
    error = Error,
    onError = DarkOnBackground,
    errorContainer = Error.copy(alpha = 0.2f),
    onErrorContainer = Error,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurface.copy(alpha = 0.7f),
    outline = Primary.copy(alpha = 0.3f),
    outlineVariant = Primary.copy(alpha = 0.1f),
    scrim = DarkBackground,
    inverseSurface = DarkOnSurface,
    inverseOnSurface = DarkSurface,
    inversePrimary = PrimaryDark,
    surfaceTint = Primary
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = LightOnBackground,
    primaryContainer = PrimaryLight.copy(alpha = 0.2f),
    onPrimaryContainer = PrimaryDark,
    secondary = Secondary,
    onSecondary = LightOnBackground,
    secondaryContainer = SecondaryLight,
    onSecondaryContainer = PrimaryDark,
    tertiary = AccentPurple,
    onTertiary = LightOnBackground,
    error = Error,
    onError = LightOnBackground,
    errorContainer = Error.copy(alpha = 0.2f),
    onErrorContainer = Error,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurface.copy(alpha = 0.7f),
    outline = Primary.copy(alpha = 0.3f),
    outlineVariant = Primary.copy(alpha = 0.1f),
    scrim = DarkBackground,
    inverseSurface = LightOnSurface,
    inverseOnSurface = LightSurface,
    inversePrimary = PrimaryLight,
    surfaceTint = Primary
)

@Composable
fun PondTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Disable dynamic color for our custom theme
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
