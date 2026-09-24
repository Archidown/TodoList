package com.example.todo_list.view.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    background = LightBackground,
    surface = LightSurface,
    onPrimary = LightTextPrimary,
    onSecondary = LightTextSecondary,
    outline = LightCheckboxBorder,
    outlineVariant = LightDivider

)

private val DarkColors = darkColorScheme(
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = DarkTextPrimary,
    onSecondary = DarkTextSecondary,
    outline = DarkCheckboxBorder,
    outlineVariant = DarkDivider

)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}