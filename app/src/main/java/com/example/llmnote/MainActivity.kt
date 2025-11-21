package com.example.llmnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = com.example.llmnote.ui.navigation.Screen.NoteList.route
                    ) {
                        composable(route = com.example.llmnote.ui.navigation.Screen.NoteList.route) {
                            com.example.llmnote.ui.note_list.NoteListScreen(navController = navController)
                        }
                        composable(
                            route = com.example.llmnote.ui.navigation.Screen.NoteEdit.route,
                            arguments = listOf(
                                navArgument(name = "noteId") {
                                    type = NavType.LongType
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
