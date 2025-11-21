package com.example.llmnote

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.koin.core.context.startKoin
import com.example.llmnote.di.appModule

fun main() = application {
    startKoin {
        modules(appModule)
    }
    
    Window(onCloseRequest = ::exitApplication, title = "LLM Note") {
        LLMNoteApp()
    }
}
