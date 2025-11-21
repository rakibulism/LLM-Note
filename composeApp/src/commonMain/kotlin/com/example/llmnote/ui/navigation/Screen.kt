package com.example.llmnote.ui.navigation

sealed class Screen(val route: String) {
    object NoteList : Screen("note_list")
    object NoteEdit : Screen("note_edit?noteId={noteId}") {
        fun createRoute(noteId: Long? = null): String {
            return "note_edit?noteId=${noteId ?: -1L}"
        }
    }
}
