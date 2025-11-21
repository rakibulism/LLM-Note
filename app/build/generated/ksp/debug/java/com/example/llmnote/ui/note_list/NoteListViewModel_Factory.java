package com.example.llmnote.ui.note_list;

import com.example.llmnote.domain.usecase.AddNoteUseCase;
import com.example.llmnote.domain.usecase.DeleteNoteUseCase;
import com.example.llmnote.domain.usecase.GetNotesUseCase;
import com.example.llmnote.domain.usecase.SearchNotesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NoteListViewModel_Factory implements Factory<NoteListViewModel> {
  private final Provider<GetNotesUseCase> getNotesUseCaseProvider;

  private final Provider<DeleteNoteUseCase> deleteNoteUseCaseProvider;

  private final Provider<SearchNotesUseCase> searchNotesUseCaseProvider;

  private final Provider<AddNoteUseCase> addNoteUseCaseProvider;

  public NoteListViewModel_Factory(Provider<GetNotesUseCase> getNotesUseCaseProvider,
      Provider<DeleteNoteUseCase> deleteNoteUseCaseProvider,
      Provider<SearchNotesUseCase> searchNotesUseCaseProvider,
      Provider<AddNoteUseCase> addNoteUseCaseProvider) {
    this.getNotesUseCaseProvider = getNotesUseCaseProvider;
    this.deleteNoteUseCaseProvider = deleteNoteUseCaseProvider;
    this.searchNotesUseCaseProvider = searchNotesUseCaseProvider;
    this.addNoteUseCaseProvider = addNoteUseCaseProvider;
  }

  @Override
  public NoteListViewModel get() {
    return newInstance(getNotesUseCaseProvider.get(), deleteNoteUseCaseProvider.get(), searchNotesUseCaseProvider.get(), addNoteUseCaseProvider.get());
  }

  public static NoteListViewModel_Factory create(Provider<GetNotesUseCase> getNotesUseCaseProvider,
      Provider<DeleteNoteUseCase> deleteNoteUseCaseProvider,
      Provider<SearchNotesUseCase> searchNotesUseCaseProvider,
      Provider<AddNoteUseCase> addNoteUseCaseProvider) {
    return new NoteListViewModel_Factory(getNotesUseCaseProvider, deleteNoteUseCaseProvider, searchNotesUseCaseProvider, addNoteUseCaseProvider);
  }

  public static NoteListViewModel newInstance(GetNotesUseCase getNotesUseCase,
      DeleteNoteUseCase deleteNoteUseCase, SearchNotesUseCase searchNotesUseCase,
      AddNoteUseCase addNoteUseCase) {
    return new NoteListViewModel(getNotesUseCase, deleteNoteUseCase, searchNotesUseCase, addNoteUseCase);
  }
}
