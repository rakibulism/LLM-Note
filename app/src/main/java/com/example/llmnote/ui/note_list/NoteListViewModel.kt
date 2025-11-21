package com.example.llmnote.ui.note_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.llmnote.data.local.entity.NoteEntity
import com.example.llmnote.domain.usecase.DeleteNoteUseCase
import com.example.llmnote.domain.usecase.GetNotesUseCase
import com.example.llmnote.domain.usecase.SearchNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val searchNotesUseCase: SearchNotesUseCase
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
}
