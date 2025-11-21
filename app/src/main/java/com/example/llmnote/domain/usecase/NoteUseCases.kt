package com.example.llmnote.domain.usecase

import com.example.llmnote.data.local.entity.NoteEntity
import com.example.llmnote.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<NoteEntity>> = repository.getAllNotes()
}

class GetNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Long): NoteEntity? = repository.getNoteById(id)
}

class AddNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: NoteEntity) {
        if (note.title.isBlank() && note.content.isBlank()) return
        repository.insertNote(note)
    }
}

class DeleteNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: NoteEntity) = repository.deleteNote(note)
}

class SearchNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(query: String): Flow<List<NoteEntity>> = repository.searchNotes(query)
}
