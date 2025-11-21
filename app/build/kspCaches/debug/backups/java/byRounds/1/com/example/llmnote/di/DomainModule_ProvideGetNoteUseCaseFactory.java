package com.example.llmnote.di;

import com.example.llmnote.data.repository.NoteRepository;
import com.example.llmnote.domain.usecase.GetNoteUseCase;
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
public final class DomainModule_ProvideGetNoteUseCaseFactory implements Factory<GetNoteUseCase> {
  private final Provider<NoteRepository> repositoryProvider;

  public DomainModule_ProvideGetNoteUseCaseFactory(Provider<NoteRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetNoteUseCase get() {
    return provideGetNoteUseCase(repositoryProvider.get());
  }

  public static DomainModule_ProvideGetNoteUseCaseFactory create(
      Provider<NoteRepository> repositoryProvider) {
    return new DomainModule_ProvideGetNoteUseCaseFactory(repositoryProvider);
  }

  public static GetNoteUseCase provideGetNoteUseCase(NoteRepository repository) {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetNoteUseCase(repository));
  }
}
