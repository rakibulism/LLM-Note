package com.example.llmnote.di;

import com.example.llmnote.data.repository.NoteRepository;
import com.example.llmnote.domain.usecase.AddNoteUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("dagger.hilt.android.scopes.ViewModelScoped")
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
public final class DomainModule_ProvideAddNoteUseCaseFactory implements Factory<AddNoteUseCase> {
  private final Provider<NoteRepository> repositoryProvider;

  public DomainModule_ProvideAddNoteUseCaseFactory(Provider<NoteRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AddNoteUseCase get() {
    return provideAddNoteUseCase(repositoryProvider.get());
  }

  public static DomainModule_ProvideAddNoteUseCaseFactory create(
      Provider<NoteRepository> repositoryProvider) {
    return new DomainModule_ProvideAddNoteUseCaseFactory(repositoryProvider);
  }

  public static AddNoteUseCase provideAddNoteUseCase(NoteRepository repository) {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideAddNoteUseCase(repository));
  }
}
