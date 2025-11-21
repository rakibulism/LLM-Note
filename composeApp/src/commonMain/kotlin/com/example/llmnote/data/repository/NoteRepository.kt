package com.example.llmnote.data.repository

import com.example.llmnote.data.local.dao.NoteDao
import com.example.llmnote.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow


class NoteRepository(
    private val noteDao: NoteDao
) {
    fun getAllNotes(): Flow<List<NoteEntity>> = noteDao.getAllNotes()

    fun searchNotes(query: String): Flow<List<NoteEntity>> = noteDao.searchNotes(query)

    suspend fun getNoteById(id: Long): NoteEntity? = noteDao.getNoteById(id)

    suspend fun insertNote(note: NoteEntity) = noteDao.insertNote(note)

    suspend fun deleteNote(note: NoteEntity) = noteDao.deleteNote(note)
}
