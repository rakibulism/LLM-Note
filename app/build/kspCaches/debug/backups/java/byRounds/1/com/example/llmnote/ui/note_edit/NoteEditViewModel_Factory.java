package com.example.llmnote.ui.note_edit;

import androidx.lifecycle.SavedStateHandle;
import com.example.llmnote.domain.usecase.AddNoteUseCase;
import com.example.llmnote.domain.usecase.GetNoteUseCase;
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
public final class NoteEditViewModel_Factory implements Factory<NoteEditViewModel> {
  private final Provider<GetNoteUseCase> getNoteUseCaseProvider;

  private final Provider<AddNoteUseCase> addNoteUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public NoteEditViewModel_Factory(Provider<GetNoteUseCase> getNoteUseCaseProvider,
      Provider<AddNoteUseCase> addNoteUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getNoteUseCaseProvider = getNoteUseCaseProvider;
    this.addNoteUseCaseProvider = addNoteUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public NoteEditViewModel get() {
    return newInstance(getNoteUseCaseProvider.get(), addNoteUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static NoteEditViewModel_Factory create(Provider<GetNoteUseCase> getNoteUseCaseProvider,
      Provider<AddNoteUseCase> addNoteUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new NoteEditViewModel_Factory(getNoteUseCaseProvider, addNoteUseCaseProvider, savedStateHandleProvider);
  }

  public static NoteEditViewModel newInstance(GetNoteUseCase getNoteUseCase,
      AddNoteUseCase addNoteUseCase, SavedStateHandle savedStateHandle) {
    return new NoteEditViewModel(getNoteUseCase, addNoteUseCase, savedStateHandle);
  }
}
