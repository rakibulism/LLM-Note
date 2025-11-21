package com.example.llmnote.ui.note_edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.llmnote.data.local.entity.NoteEntity
import com.example.llmnote.domain.usecase.AddNoteUseCase
import com.example.llmnote.domain.usecase.GetNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteEditViewModel @Inject constructor(
    private val getNoteUseCase: GetNoteUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _noteTitle = mutableStateOf("")
    val noteTitle: State<String> = _noteTitle

    private val _noteContent = mutableStateOf("")
    val noteContent: State<String> = _noteContent

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Long? = null

    init {
        savedStateHandle.get<Long>("noteId")?.let { noteId ->
            if (noteId != -1L) {
                viewModelScope.launch {
                    getNoteUseCase(noteId)?.also { note ->
                        currentNoteId = note.id
                        _noteTitle.value = note.title
                        _noteContent.value = note.content
                    }
                }
            }
        }
    }

    fun onEvent(event: NoteEditEvent) {
        when (event) {
            is NoteEditEvent.EnteredTitle -> {
                _noteTitle.value = event.value
            }
            is NoteEditEvent.EnteredContent -> {
                _noteContent.value = event.value
            }
            is NoteEditEvent.SaveNote -> {
                viewModelScope.launch {
                    addNoteUseCase(
                        NoteEntity(
                            id = currentNoteId ?: 0,
                            title = noteTitle.value,
                            content = noteContent.value,
                            timestamp = System.currentTimeMillis()
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveNote)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveNote : UiEvent()
    }
}

sealed class NoteEditEvent {
    data class EnteredTitle(val value: String) : NoteEditEvent()
    data class EnteredContent(val value: String) : NoteEditEvent()
    object SaveNote : NoteEditEvent()
}
