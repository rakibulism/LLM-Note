package com.example.llmnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.llmnote.ui.theme.LLMNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LLMNoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = androidx.navigation.compose.rememberNavController()
                    androidx.navigation.compose.NavHost(
                        navController = navController,
                        startDestination = com.example.llmnote.ui.navigation.Screen.NoteList.route
                    ) {
                        androidx.navigation.compose.composable(route = com.example.llmnote.ui.navigation.Screen.NoteList.route) {
                            com.example.llmnote.ui.note_list.NoteListScreen(navController = navController)
                        }
                        androidx.navigation.compose.composable(
                            route = com.example.llmnote.ui.navigation.Screen.NoteEdit.route,
                            arguments = listOf(
                                androidx.navigation.navArgument(name = "noteId") {
                                    type = androidx.navigation.NavType.LongType
                                    defaultValue = -1L
                                }
                            )
                        ) {
                            com.example.llmnote.ui.note_edit.NoteEditScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
