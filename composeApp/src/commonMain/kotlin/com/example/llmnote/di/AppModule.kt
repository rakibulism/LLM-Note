package com.example.llmnote.di

import com.example.llmnote.data.local.AppDatabase
import com.example.llmnote.data.local.getDatabaseBuilder
import com.example.llmnote.data.repository.NoteRepository
import com.example.llmnote.domain.usecase.AddNoteUseCase
import com.example.llmnote.domain.usecase.DeleteNoteUseCase
import com.example.llmnote.domain.usecase.GetNoteUseCase
import com.example.llmnote.domain.usecase.GetNotesUseCase
import com.example.llmnote.domain.usecase.SearchNotesUseCase
import com.example.llmnote.ui.note_edit.NoteEditViewModel
import com.example.llmnote.ui.note_list.NoteListViewModel
import org.koin.dsl.module

val appModule = module {
    single { 
        getDatabaseBuilder()
            .setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver())
            .build()
    }
    single { get<AppDatabase>().noteDao() }
    
    single { NoteRepository(get()) }
    
    factory { GetNotesUseCase(get()) }
    factory { GetNoteUseCase(get()) }
    factory { AddNoteUseCase(get()) }
    factory { DeleteNoteUseCase(get()) }
    factory { SearchNotesUseCase(get()) }
    
    factory { NoteListViewModel(get(), get(), get(), get()) }
    factory { (savedStateHandle: androidx.lifecycle.SavedStateHandle) -> 
        NoteEditViewModel(get(), get(), savedStateHandle) 
    }
}
