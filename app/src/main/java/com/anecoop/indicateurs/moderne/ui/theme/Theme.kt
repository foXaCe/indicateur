package com.anecoop.indicateurs.moderne.ui.theme

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4FDBD2),
    onPrimary = Color(0xFF003734),
    primaryContainer = Color(0xFF00504B),
    onPrimaryContainer = Color(0xFF80F2EA),
    secondary = Color(0xFFB1CCC6),
    onSecondary = Color(0xFF1C3732),
    tertiary = Color(0xFFB0C9E4),
    background = Color(0xFF0F1514),
    surface = Color(0xFF0F1514),
    onBackground = Color(0xFFE0E3E1),
    onSurface = Color(0xFFE0E3E1),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF006A63),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF80F2EA),
    onPrimaryContainer = Color(0xFF00201E),
    secondary = Color(0xFF4A635F),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFF456179),
    background = Color(0xFFF7FAFA),
    surface = Color(0xFFF7FAFA),
    onBackground = Color(0xFF191C1C),
    onSurface = Color(0xFF191C1C),
)

@Composable
fun IndicateursModerneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
