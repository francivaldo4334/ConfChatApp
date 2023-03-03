package br.com.fran.confchat.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = primary,
    primaryVariant = primary,
    secondary = primary,
    background = background,
    onBackground = on_background,
    onPrimary = on_primary
)
@Composable
fun ConfChatTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}