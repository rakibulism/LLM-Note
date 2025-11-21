package com.example.llmnote.ui.note_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.llmnote.data.local.entity.NoteEntity
import com.example.llmnote.domain.usecase.AddNoteUseCase
import com.example.llmnote.domain.usecase.DeleteNoteUseCase
import com.example.llmnote.domain.usecase.GetNotesUseCase
import com.example.llmnote.domain.usecase.SearchNotesUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class NoteListViewModel(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val searchNotesUseCase: SearchNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NoteListState())
    val state: StateFlow<NoteListState> = _state.asStateFlow()

    private var searchJob: Job? = null

    init {
        getNotes()
    }

    fun onEvent(event: NoteListEvent) {
        when (event) {
            is NoteListEvent.DeleteNote -> {
                viewModelScope.launch {
                    deleteNoteUseCase(event.note)
                }
            }
            is NoteListEvent.OnSearchQueryChange -> {
                _state.value = _state.value.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    searchNotesUseCase(event.query).onEach { notes ->
                        _state.value = _state.value.copy(notes = notes)
                    }.launchIn(this)
                }
            }
            is NoteListEvent.TogglePin -> {
                viewModelScope.launch {
                    addNoteUseCase(event.note.copy(isPinned = !event.note.isPinned))
                }
            }
        }
    }

    private fun getNotes() {
        getNotesUseCase().onEach { notes ->
            _state.value = _state.value.copy(notes = notes)
        }.launchIn(viewModelScope)
    }
}

data class NoteListState(
    val notes: List<NoteEntity> = emptyList(),
    val searchQuery: String = ""
)

sealed class NoteListEvent {
    data class DeleteNote(val note: NoteEntity) : NoteListEvent()
    data class OnSearchQueryChange(val query: String) : NoteListEvent()
    data class TogglePin(val note: NoteEntity) : NoteListEvent()
}
