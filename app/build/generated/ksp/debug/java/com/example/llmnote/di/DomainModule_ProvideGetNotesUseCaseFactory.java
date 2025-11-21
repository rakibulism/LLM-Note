package com.example.llmnote.di;

import com.example.llmnote.data.repository.NoteRepository;
import com.example.llmnote.domain.usecase.GetNotesUseCase;
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
public final class DomainModule_ProvideGetNotesUseCaseFactory implements Factory<GetNotesUseCase> {
  private final Provider<NoteRepository> repositoryProvider;

  public DomainModule_ProvideGetNotesUseCaseFactory(Provider<NoteRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetNotesUseCase get() {
    return provideGetNotesUseCase(repositoryProvider.get());
  }

  public static DomainModule_ProvideGetNotesUseCaseFactory create(
      Provider<NoteRepository> repositoryProvider) {
    return new DomainModule_ProvideGetNotesUseCaseFactory(repositoryProvider);
  }

  public static GetNotesUseCase provideGetNotesUseCase(NoteRepository repository) {
    return Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetNotesUseCase(repository));
  }
}
