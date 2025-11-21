package com.example.llmnote.di;

import com.example.llmnote.data.repository.NoteRepository;
import com.example.llmnote.domain.usecase.SearchNotesUseCase;
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
public final class DomainModule_ProvideSearchNotesUseCaseFactory implements Factory<SearchNotesUseCase> {
  private final Provider<NoteRepository> repositoryProvider;

  public DomainModule_ProvideSearchNotesUseCaseFactory(
      Provider<NoteRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SearchNotesUseCase get() {
    return provideSearchNotesUseCase(repositoryProvider.get());
  }

  public static DomainModule_ProvideSearchNotesUseCaseFactory create(
      Provider<NoteRepository> repositoryProvider) {
    return new DomainModule_ProvideSearchNotesUseCaseFactory(repositoryProvider);
  }

  public static SearchNotesUseCase provideSearchNotesUseCase(NoteRepository repository) {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideSearchNotesUseCase(repository));
  }
}
