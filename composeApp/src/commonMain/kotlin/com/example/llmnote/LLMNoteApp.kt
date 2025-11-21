package com.example.llmnote

import androidx.compose.runtime.Composable
import com.example.llmnote.ui.theme.LLMNoteTheme
import com.example.llmnote.ui.navigation.Screen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.llmnote.ui.note_list.NoteListScreen
import com.example.llmnote.ui.note_edit.NoteEditScreen
import org.koin.compose.KoinContext

@Composable
fun LLMNoteApp() {
    KoinContext {
        LLMNoteTheme {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.NoteList.route
            ) {
                composable(route = Screen.NoteList.route) {
                    NoteListScreen(navController = navController)
                }
                composable(
                    route = Screen.NoteEdit.route,
                    arguments = listOf(
                        navArgument(name = "noteId") {
                            type = NavType.LongType
                            defaultValue = -1L
                        }
                    )
                ) {
                    NoteEditScreen(navController = navController)
                }
            }
        }
    }
}
