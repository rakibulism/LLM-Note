package com.example.llmnote.domain.usecase

import com.example.llmnote.data.local.entity.NoteEntity
import com.example.llmnote.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow


class GetNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<NoteEntity>> = repository.getAllNotes()
}

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Long): NoteEntity? = repository.getNoteById(id)
}

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: NoteEntity) {
        if (note.title.isBlank() && note.content.isBlank()) return
        repository.insertNote(note)
    }
}

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: NoteEntity) = repository.deleteNote(note)
}

class SearchNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(query: String): Flow<List<NoteEntity>> = repository.searchNotes(query)
}
