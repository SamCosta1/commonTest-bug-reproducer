@file:Suppress("PACKAGE_NAME_MISSING")

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.*
import com.example.App

fun main() = application {
    val state = rememberWindowState(
        placement = WindowPlacement.Floating,
        position = WindowPosition(Alignment.Center),
        isMinimized = false
    )


    Window(
        title = "Test",
        resizable = true,
        state = state,
        icon = null,
        onCloseRequest = ::exitApplication,
        content = {
            App()
        }
    )
}
