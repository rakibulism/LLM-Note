package com.example.llmnote.di;

import com.example.llmnote.data.repository.NoteRepository;
import com.example.llmnote.domain.usecase.DeleteNoteUseCase;
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
public final class DomainModule_ProvideDeleteNoteUseCaseFactory implements Factory<DeleteNoteUseCase> {
  private final Provider<NoteRepository> repositoryProvider;

  public DomainModule_ProvideDeleteNoteUseCaseFactory(Provider<NoteRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public DeleteNoteUseCase get() {
    return provideDeleteNoteUseCase(repositoryProvider.get());
  }

  public static DomainModule_ProvideDeleteNoteUseCaseFactory create(
      Provider<NoteRepository> repositoryProvider) {
    return new DomainModule_ProvideDeleteNoteUseCaseFactory(repositoryProvider);
  }

  public static DeleteNoteUseCase provideDeleteNoteUseCase(NoteRepository repository) {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDeleteNoteUseCase(repository));
  }
}
