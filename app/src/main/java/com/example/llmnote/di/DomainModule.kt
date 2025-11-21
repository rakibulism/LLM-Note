package com.example.llmnote.di

import com.example.llmnote.data.repository.NoteRepository
import com.example.llmnote.domain.usecase.AddNoteUseCase
import com.example.llmnote.domain.usecase.DeleteNoteUseCase
import com.example.llmnote.domain.usecase.GetNoteUseCase
import com.example.llmnote.domain.usecase.GetNotesUseCase
import com.example.llmnote.domain.usecase.SearchNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    fun provideGetNotesUseCase(repository: NoteRepository): GetNotesUseCase {
        return GetNotesUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetNoteUseCase(repository: NoteRepository): GetNoteUseCase {
        return GetNoteUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideAddNoteUseCase(repository: NoteRepository): AddNoteUseCase {
        return AddNoteUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteNoteUseCase(repository: NoteRepository): DeleteNoteUseCase {
        return DeleteNoteUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideSearchNotesUseCase(repository: NoteRepository): SearchNotesUseCase {
        return SearchNotesUseCase(repository)
    }
}
