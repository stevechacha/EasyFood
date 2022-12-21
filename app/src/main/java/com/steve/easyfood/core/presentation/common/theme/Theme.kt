package com.steve.easyfood.core.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = primaryDark,
    primaryContainer = primaryDark,
    onPrimary = TextWhite,
    secondary = primaryDarkVariant,
    secondaryContainer = primaryDarkVariant,
    onSecondary = TextWhite,
    surface = primaryDark,
    onSurface = TextWhite,
    background = lightGray,
    onBackground = TextWhite,
    error = primaryDark,
    onError = TextWhite,
)


@Composable
fun EasyFoodTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = DarkColorPalette,
        typography = AppTypography,
        content = content
    )
}